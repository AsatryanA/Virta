package fi.devolon.virta.controller;

import fi.devolon.virta.dto.station.*;
import fi.devolon.virta.service.StationService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/station")
public class StationController {
    private final StationService stationService;

    @PostMapping
    public ResponseEntity<StationDto> createStation(@RequestBody CreateStationDto stationDto) {
        return ResponseEntity.status(HttpStatus.OK).body(stationService.createStation(stationDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StationDto> getStationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(stationService.getStationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StationDto> updateStation(@RequestBody UpdateStationRequest stationRequest, @PathVariable @Min(1) Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(stationService.updateStation(stationRequest, id));
    }

    @DeleteMapping
    public void deleteStation(@RequestParam Long id) {
        stationService.deleteStationById(id);
    }

    @GetMapping("/all/{companyId}")
    public ResponseEntity<List<StationDto>> getAllByCompanyId(@PathVariable Long companyId) {
        return ResponseEntity.status(HttpStatus.OK).body(stationService.getStationByCompanyId(companyId));
    }

    @PostMapping("/location")
    public ResponseEntity<List<StationDto>> getStationsByLocation(@RequestBody StationByLocationDto station) {
        return ResponseEntity.status(HttpStatus.OK).body(stationService.getStationsByLocation(station));
    }

    @GetMapping
    public ResponseEntity<List<StationDto>> getAllStations() {
        return ResponseEntity.status(HttpStatus.OK).body(stationService.getAllStations());
    }
}
