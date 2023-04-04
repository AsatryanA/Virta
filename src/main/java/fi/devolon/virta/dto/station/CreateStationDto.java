package fi.devolon.virta.dto.station;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStationDto extends BaseStationDto {

    @NotBlank
    private Long companyId;
}
