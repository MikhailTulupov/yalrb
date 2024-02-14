package ru.yalrb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * This class represents entity {@link Level} for the ability to score
 * points for {@link Account} users for various actions on the site and fill their
 * {@link Level} on the site with these points. Entity {@link Level} have many relationships with others
 * entities: {@link Account} and {@link LevelType}.
 */
@AllArgsConstructor
@Data
@Builder
@Entity
@RequiredArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @OneToOne(mappedBy = "level")
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "level_type_guid")
    private LevelType levelType;

    private int score;
}
