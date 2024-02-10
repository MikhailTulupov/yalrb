package ru.yalrb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@Entity
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "appeals")
public class AppealState {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "appealState")
    @ToString.Exclude
    @Builder.Default
    private Set<Appeal> appeals = new HashSet<>();
}
