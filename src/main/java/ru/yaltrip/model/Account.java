package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * This class represents entity {@link Account} for site user, witch can log in or sign in.
 * This entity {@link Account} have many relationships with others entities:
 * {@link Role}, {@link Level}, {@link Feedback}, {@link Score}, {@link Object} and {@link State}.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(exclude = {"feedbacks", "objects", "scores", "states", "role", "level"})
@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Date createdDateTime;

    @ToString.Exclude
    @JoinColumn(name = "role_guid")
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private Role role;

    @ToString.Exclude
    @JoinColumn(name = "level_guid")
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Level level;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "account")
    private Set<Feedback> feedbacks = new HashSet<>();

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "account")
    private Set<Score> scores = new HashSet<>();

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "account")
    private Set<Object> objects = new HashSet<>();

    @ToString.Exclude
    @Builder.Default
    @ManyToMany(mappedBy = "accounts")
    private Set<State> states = new HashSet<>();
}
