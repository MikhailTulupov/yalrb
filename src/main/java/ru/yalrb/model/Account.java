package ru.yalrb.model;

import com.fasterxml.jackson.annotation.*;
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
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"feedbacks", "objects", "scores", "states"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_guid")
    private Role role;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "level_guid")
    @JsonManagedReference(value = "account-level")
    private Level level;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;

    @Column(nullable = false)
    private Date createdDateTime;

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    @Builder.Default
    @JsonManagedReference(value = "account-feedbacks")
    private Set<Feedback> feedbacks = new HashSet<>();

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    @Builder.Default
    @JsonManagedReference(value = "account-scores")
    private Set<Score> scores = new HashSet<>();

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    @Builder.Default
    @JsonManagedReference(value = "account-objects")
    private Set<Object> objects = new HashSet<>();

    @ManyToMany(mappedBy = "accounts")
    @ToString.Exclude
    @Builder.Default
    private Set<State> states = new HashSet<>();
}
