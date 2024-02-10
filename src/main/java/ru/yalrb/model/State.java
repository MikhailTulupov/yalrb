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
@EqualsAndHashCode(exclude = {"objects", "accounts"})
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String Description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "object_state",
            joinColumns = @JoinColumn(name = "object_guid"),
            inverseJoinColumns = @JoinColumn(name = "state_guid"))
    @ToString.Exclude
    @Builder.Default
    private Set<Object> objects = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_state",
            joinColumns = @JoinColumn(name = "account_guid"),
            inverseJoinColumns = @JoinColumn(name = "state_guid"))
    @ToString.Exclude
    @Builder.Default
    private Set<Account> accounts = new HashSet<>();

}
