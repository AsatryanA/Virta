package fi.devolon.virta.dto.station;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseStationDto {
    @NotBlank
    private String name;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
}
