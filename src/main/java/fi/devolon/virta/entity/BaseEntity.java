package fi.devolon.virta.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.util.Objects.nonNull;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

    @PrePersist
    public void prePersist() {
        if (nonNull(this.createdDate) && nonNull(lastModifiedDate)) {
            return;
        }
        LocalDateTime now = LocalDateTime.now();
        setCreatedDate(now);
        setLastModifiedDate(now);
    }

    @PreUpdate
    public void preUpdate() {
        setLastModifiedDate(LocalDateTime.now());
    }


}