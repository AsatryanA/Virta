package fi.devolon.virta.repository;

import fi.devolon.virta.entity.CompanyEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;
    private CompanyEntity save;

    @BeforeEach
    public void setupTestEntity() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(1L);
        companyEntity.setName("StationCompany");
        save = companyRepository.save(companyEntity);
    }

    @Test
    void shouldSaveCompanyTest() {
        assertEquals(1L, save.getId());
    }

    @Test
    void shouldGetCompanyByIdTest() {
        var byId = companyRepository.findById(1L);
        assertTrue(byId.isPresent());
    }

    @Test
    void shouldUpdateCompanyTest() {
        save.setName("Updated");
        var save1 = companyRepository.save(save);
        assertEquals("Updated", save1.getName());
    }

    @Test
    void shouldDeleteCompanyTest() {
        companyRepository.delete(save);
        var byId = companyRepository.findById(1L);
        assertTrue(byId.isEmpty());
    }


    @Test
    void shouldGetAllChildByCompanyIdTest() {
/*        CompanyEntity child1 = new CompanyEntity();
        child1.setName("child1");
        child1.setParentCompany(save);
        companyRepository.save(child1);

        CompanyEntity child2 = new CompanyEntity();
        child2.setName("child2");
        child2.setParentCompany(save);
        companyRepository.save(child2);

        CompanyEntity child3 = new CompanyEntity();
        child3.setName("child3");
        child3.setParentCompany(save);
        companyRepository.save(child3);

        var allByParentCompanyId = companyRepository.findAllByParentCompanyId(1L);
       Assertions.assertThat(allByParentCompanyId.get().size()).isEqualTo(3);*/
    }
}