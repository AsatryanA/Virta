package fi.devolon.virta.dto.company;

import fi.devolon.virta.dto.station.StationDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CompanyWithStationsDto extends CompanyDto {
    private List<StationDto> stations;
}
