package fi.devolon.virta.mapper;

import fi.devolon.virta.dto.company.*;
import fi.devolon.virta.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",uses = {StationMapper.class})
public interface CompanyMapper {
    CompanyDto toDto(CompanyEntity companyEntity);
    ChildCompanyDto toChildDto(CompanyEntity companyEntity);
    CompanyWithStationsDto toCompanyWithStationsDto(CompanyEntity companyEntity);
    CompanyEntity toEntity(CreateCompanyRequest companyDto);
    CompanyEntity toEntity(@MappingTarget CompanyEntity companyEntity, UpdateCompanyRequest companyDto);
}
