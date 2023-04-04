package fi.devolon.virta.service.impl;

import fi.devolon.virta.dto.station.*;
import fi.devolon.virta.exception.ResourceNotFoundException;
import fi.devolon.virta.mapper.StationMapper;
import fi.devolon.virta.repository.CompanyRepository;
import fi.devolon.virta.repository.StationRepository;
import fi.devolon.virta.service.StationService;
import jakarta.persistence.criteria.JoinType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;
    private final CompanyRepository companyRepository;
    private final StationMapper stationMapper;


    @Override
    @Transactional
    public StationDto createStation(CreateStationDto stationDto) {
        var company = companyRepository.findById(stationDto.getCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException(stationDto.getCompanyId()));
        var stationEntity = stationMapper.toEntity(stationDto);
        stationEntity.setCompany(company);
        var save = stationRepository.save(stationEntity);
        return stationMapper.toDto(save);
    }

    @Override
    public StationDto getStationById(Long id) {
        var stationEntity = stationRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return stationMapper.toDto(stationEntity);
    }

    @Override
    public StationDto updateStation(UpdateStationRequest stationRequest, Long id) {
        var stationEntity = stationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
        var updatedEntity = stationMapper.toEntity(stationEntity, stationRequest);
        stationRepository.save(updatedEntity);
        return stationMapper.toDto(updatedEntity);
    }

    @Override
    public void deleteStationById(Long id) {
        stationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        stationRepository.deleteById(id);
    }

    @Override
    public List<StationDto> getStationByCompanyId(Long companyId) {
        var company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException(companyId));
        var allStationsByCompanyId = stationRepository.findAllByCompanyId(companyId);
        var collect = allStationsByCompanyId
                .stream().map(stationMapper::toDto)
                .toList();
        return collect;
    }

    @Override
    public List<StationDto> getStationsByLocation(StationByLocationDto station) {
        var allByLocation = stationRepository.findAllByLocation
                (station.getLatitude(), station.getLongitude(), station.getDistance());
        return allByLocation.stream().map(stationMapper::toDto).toList();
    }

    @Override
    public List<StationDto> getAllStations() {
        var stations = stationRepository.findAll((root, query, criteriaBuilder) -> {
            root.fetch("company", JoinType.INNER);
            return criteriaBuilder.conjunction();
        });
        return stations.stream().map(stationMapper::toDto).toList();
    }
}
