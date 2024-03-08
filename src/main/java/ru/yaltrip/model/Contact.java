package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * This class represents entity {@link Contact} it`s dependent of {@link Object}.
 * Entity {@link Contact} contains all required data for contacting to owner this {@link Object}.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(exclude = "objects")
@RequiredArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    private String siteLink;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "contact")
    private Set<Object> objects = new HashSet<>();
}
