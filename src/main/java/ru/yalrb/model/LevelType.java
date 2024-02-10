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
@EqualsAndHashCode(exclude = "levels")
@RequiredArgsConstructor
public class LevelType {
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
    @OneToMany(mappedBy = "levelType")
    private Set<Level> levels = new HashSet<>();
}
