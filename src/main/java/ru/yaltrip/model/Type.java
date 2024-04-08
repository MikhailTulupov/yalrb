package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * This class is a data model of the YalTrip service. It complements the {@link Object} model.
 * This class means All objects can have type, such like a sanatorium, hotel, recreation center,
 *  * cultural attraction or natural landmark is located.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(exclude = "objects")
@RequiredArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "type")
    private Set<Object> objects = new HashSet<>();
}
