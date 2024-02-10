package ru.yalrb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@Entity
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"feedbacks", "objects", "scores", "states"})
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
    private Set<Feedback> feedbacks = new HashSet<>();

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    @Builder.Default
    private Set<Score> scores = new HashSet<>();

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    @Builder.Default
    private Set<Object> objects = new HashSet<>();

    @ManyToMany(mappedBy = "accounts")
    @ToString.Exclude
    @Builder.Default
    private Set<State> states = new HashSet<>();
}
