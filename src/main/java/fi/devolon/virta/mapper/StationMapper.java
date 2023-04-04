package fi.devolon.virta.mapper;

import fi.devolon.virta.dto.station.CreateStationDto;
import fi.devolon.virta.dto.station.StationDto;
import fi.devolon.virta.dto.station.UpdateStationRequest;
import fi.devolon.virta.entity.StationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StationMapper {
    StationDto toDto(StationEntity stationEntity);

    StationEntity toEntity(CreateStationDto stationDto);

    StationEntity toEntity(@MappingTarget StationEntity stationEntity, UpdateStationRequest stationRequest);
}
