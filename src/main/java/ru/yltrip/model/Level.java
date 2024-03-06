package ru.yltrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * This class represents entity {@link Level} for the ability to score
 * points for {@link Account} users for various actions on the site and fill their
 * {@link Level} on the site with these points. Entity {@link Level} have many relationships with others
 * entities: {@link Account} and {@link LevelType}.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@RequiredArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private int score;

    @ToString.Exclude
    @OneToOne(mappedBy = "level")
    private Account account;

    @ToString.Exclude
    @JoinColumn(name = "level_type_guid")
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private LevelType levelType;
}
