package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * This class is a data model of the YalTrip service. It complements the {@link Object} model.
 * This model contains geolocation data where the object is located.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@RequiredArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private float longitude;

    @Column(nullable = false)
    private float latitude;

    @OneToOne(mappedBy = "location")
    private Object object;
}
