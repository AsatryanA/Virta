package fi.devolon.virta.dto.station;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StationResponseDto extends BaseStationDto{
    private Long id;
    private Double distance;
}
