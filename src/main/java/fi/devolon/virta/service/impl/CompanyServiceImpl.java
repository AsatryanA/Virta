package fi.devolon.virta.service.impl;

import fi.devolon.virta.dto.company.*;
import fi.devolon.virta.exception.ResourceNotFoundException;
import fi.devolon.virta.mapper.CompanyMapper;
import fi.devolon.virta.repository.CompanyRepository;
import fi.devolon.virta.service.CompanyService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.criteria.JoinType;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    @Transactional
    public CompanyDto createCompany(CreateCompanyRequest companyDto) {
        if (companyRepository.existsByName(companyDto.getName()))
            throw new EntityExistsException();
        var companyEntity = Mappers.getMapper(CompanyMapper.class).toEntity(companyDto);
        companyRepository.save(companyEntity);
        return Mappers.getMapper(CompanyMapper.class).toDto(companyEntity);
    }

    @Override
    @Transactional
    public void addChildCompanies(AddChildCompaniesRequest addChildCompaniesRequest, Long id) {
        var companyEntity = companyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
        var allByIds = companyRepository.findAllByIdIn(addChildCompaniesRequest.getChildIds());
        allByIds.forEach(child -> child.setParentCompany(companyEntity));
        companyRepository.saveAll(allByIds);
    }

    @Override
    @Transactional(readOnly = true)
    public CompanyWithStationsDto getCompanyById(Long id) {
        var companyEntity = companyRepository.findOne((root, query, criteriaBuilder) -> {
            root.fetch("stations", JoinType.LEFT);
            return criteriaBuilder.equal(root.get("id"), id);
        }).orElseThrow(
                () -> new ResourceNotFoundException(id));
        var companyWithStationsDto = companyMapper.toCompanyWithStationsDto(companyEntity);
        var companyEntities = companyRepository.findAllByParentCompanyId(id).orElse(new ArrayList<>());
        companyWithStationsDto.setChildCompanies(companyEntities.stream().map(companyMapper::toChildDto).collect(Collectors.toList()));
        return companyWithStationsDto;
    }

    @Override
    @Transactional
    public CompanyDto updateCompany(UpdateCompanyRequest updateCompanyRequest, Long id) {
        var companyEntity = companyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
        var updatedEntity = companyMapper.toEntity(companyEntity, updateCompanyRequest);
        companyRepository.save(updatedEntity);
        return companyMapper.toDto(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteCompanyById(Long id) {
        companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        companyRepository.deleteById(id);
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream().map(companyMapper::toDto).toList();
    }
}
