package ru.yltrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * This class represents entity {@link Location} it`s dependent of {@link Object}
 * and represents location some place provides longitude and latitude this {@link Object}.
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
