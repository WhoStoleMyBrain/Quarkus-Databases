package org.agoncal.quarkus.panache.model;

import java.time.Duration;
import java.time.Instant;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_tracks")
public class Track extends PanacheEntity {

    @Column(nullable = false)
    public String title;
    @Column(nullable = false)
    public Duration duration;
    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_fk")
    @JsonbTransient
    public CD cd;
}
