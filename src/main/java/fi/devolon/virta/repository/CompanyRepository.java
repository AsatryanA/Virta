package fi.devolon.virta.repository;

import fi.devolon.virta.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>, JpaSpecificationExecutor<CompanyEntity> {
    boolean existsByName(String name);
    Optional<List<CompanyEntity>> findAllByParentCompanyId(Long companyId);
    List<CompanyEntity> findAllByIdIn(List<Long> childIds);
}
