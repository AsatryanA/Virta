package fi.devolon.virta.controller;

import fi.devolon.virta.dto.company.AddChildCompaniesRequest;
import fi.devolon.virta.dto.company.CompanyDto;
import fi.devolon.virta.dto.company.CreateCompanyRequest;
import fi.devolon.virta.dto.company.UpdateCompanyRequest;
import fi.devolon.virta.service.CompanyService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CreateCompanyRequest companyDto) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.createCompany(companyDto));
    }

    @PutMapping("/{id}/child")
    public void addChildCompanies(@RequestBody AddChildCompaniesRequest addChildCompaniesRequest,
                                  @PathVariable @Min(1) Long id) {
        companyService.addChildCompanies(addChildCompaniesRequest, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@RequestBody UpdateCompanyRequest updateCompanyRequest,
                                                    @PathVariable @Min(1) Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.updateCompany(updateCompanyRequest, id));
    }

    @DeleteMapping
    public void deleteCompany(@RequestParam Long id) {
        companyService.deleteCompanyById(id);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getAllCompanies());
    }
}
