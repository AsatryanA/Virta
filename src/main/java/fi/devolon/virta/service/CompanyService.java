package fi.devolon.virta.service;

import fi.devolon.virta.dto.company.AddChildCompaniesRequest;
import fi.devolon.virta.dto.company.CompanyDto;
import fi.devolon.virta.dto.company.CreateCompanyRequest;
import fi.devolon.virta.dto.company.UpdateCompanyRequest;

import java.util.List;

public interface CompanyService {
    CompanyDto createCompany(CreateCompanyRequest companyDto);

    void addChildCompanies(AddChildCompaniesRequest addChildCompaniesRequest, Long id);

    CompanyDto getCompanyById(Long id);

    CompanyDto updateCompany(UpdateCompanyRequest updateCompanyRequest, Long id);

    void deleteCompanyById(Long id);

    List<CompanyDto> getAllCompanies();
}
