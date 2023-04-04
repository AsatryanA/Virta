package fi.devolon.virta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private CompanyEntity parentCompany;

    @OneToMany(mappedBy = "parentCompany", cascade = CascadeType.REMOVE)
    private List<CompanyEntity> child;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<StationEntity> stations;

}
