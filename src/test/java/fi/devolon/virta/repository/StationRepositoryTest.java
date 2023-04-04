package fi.devolon.virta.repository;

import fi.devolon.virta.entity.StationEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StationRepositoryTest {
    @Autowired
    private StationRepository stationRepository;
    private StationEntity save;

    @BeforeEach
    public void setupTestEntity() {
        StationEntity stationEntity = new StationEntity();
        stationEntity.setId(1L);
        stationEntity.setName("Station");
        save = stationRepository.save(stationEntity);
    }

    @Test
    void shouldSaveStationTest() {
        assertEquals(1L, save.getId());
    }

    @Test
    void shouldGetStationByIdTest() {
        var byId = stationRepository.findById(1L);
        assertTrue(byId.isPresent());
    }

    @Test
    void shouldUpdateStationTest() {
        save.setName("Updated");
        var save1 = stationRepository.save(save);
        assertEquals("Updated", save1.getName());
    }

    @Test
    void shouldDeleteStationTest() {
        stationRepository.delete(save);
        var byId = stationRepository.findById(1L);
        assertTrue(byId.isEmpty());
    }

}