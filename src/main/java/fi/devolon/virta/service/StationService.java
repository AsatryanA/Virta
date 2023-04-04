package fi.devolon.virta.service;

import fi.devolon.virta.dto.station.*;

import java.util.List;

public interface StationService {
    StationDto createStation(CreateStationDto stationDto);

    StationDto getStationById(Long id);

    StationDto updateStation(UpdateStationRequest stationRequest, Long id);

    void deleteStationById(Long id);

    List<StationDto> getStationByCompanyId(Long companyId);

    List<StationDto> getStationsByLocation(StationByLocationDto station);

    List<StationDto> getAllStations();
}
