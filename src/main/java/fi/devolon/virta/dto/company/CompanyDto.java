package fi.devolon.virta.dto.company;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CompanyDto extends BaseCompanyDto {
    private Long id;
    private ParentCompanyDto parentCompany;
    private List<ChildCompanyDto> childCompanies;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
