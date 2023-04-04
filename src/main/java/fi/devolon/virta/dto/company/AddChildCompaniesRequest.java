package fi.devolon.virta.dto.company;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AddChildCompaniesRequest {
    @NotNull
    private List<Long> childIds;
}
