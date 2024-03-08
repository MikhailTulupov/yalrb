package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * This class represent entity {@link Role} witch it contains user roles on the site,
 * for example, the moderator role, the role of a regular user, and so on. This entity dependent of {@link Account}.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(exclude = "accounts")
@RequiredArgsConstructor
public class Role {
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
    @OneToMany(mappedBy = "role")
    private Set<Account> accounts = new HashSet<>();
}
