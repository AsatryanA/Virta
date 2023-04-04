package fi.devolon.virta.dto.station;

import fi.devolon.virta.dto.company.BaseCompanyDto;
import lombok.*;

@Getter
@Setter
public class StationDto extends BaseStationDto {
    private BaseCompanyDto company;
    private Long id;
}
