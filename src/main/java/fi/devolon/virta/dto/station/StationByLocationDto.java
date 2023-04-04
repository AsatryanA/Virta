package fi.devolon.virta.dto.station;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StationByLocationDto {
    @Min(-86)
    @Max(86)
    private Double latitude;
    @Min(-180)
    @Max(180)
    private Double longitude;
    @Min(0)
    private Double distance;
}
