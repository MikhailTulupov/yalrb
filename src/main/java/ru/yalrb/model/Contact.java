package ru.yalrb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@AllArgsConstructor
@Data
@Builder
@Entity
@EqualsAndHashCode(exclude = "objects")
@RequiredArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "contact")
    private Set<Object> objects = new HashSet<>();

    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    private String siteLink;
}
