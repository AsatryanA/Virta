package fi.devolon.virta.repository;

import fi.devolon.virta.entity.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<StationEntity, Long>, JpaSpecificationExecutor<StationEntity> {
    @Query(value = "WITH RECURSIVE tree AS ((SELECT id\n" +
            "                         FROM companies\n" +
            "                         WHERE id = 1)\n" +
            "                        UNION ALL\n" +
            "                        SELECT c.id\n" +
            "                        FROM companies c\n" +
            "                                 JOIN tree ON (c.parent_company_id = tree.id))\n" +
            "SELECT s.id,s.latitude,s.longitude,s.name,s.company_id, s.created_date,s.last_modified_date\n" +
            "FROM tree\n" +
            "join stations s on s.company_id = tree.id", nativeQuery = true)
    List<StationEntity> findAllByCompanyId(Long companyId);


    @Query(value = "select * from" +
            "(SELECT *,( 6371 \n" +
            "* acos( cos( radians(?1) )* cos( radians( latitude ) )\n" +
            "* cos( radians( longitude ) - radians(?2) )\n" +
            "+ sin( radians(?1) )* sin( radians( latitude )\n" +
            ") ) ) AS distance\n" +
            "FROM stations) al\n" +
            "where distance <?3\n" +
            "ORDER BY distance;",
            nativeQuery = true)
    List<StationEntity> findAllByLocation(Double lat, Double lng, Double dst);

}
