package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * This class represents entity {@link User} for site user, witch can log in or sign in.
 * This entity {@link User} have many relationships with others entities:
 * {@link Role}, {@link Level}, {@link Feedback}, {@link Score}, {@link Object} and {@link State}.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(exclude = {"feedbacks", "objects", "scores", "states", "level"})
@RequiredArgsConstructor
@Table(name = "account")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Date createdDateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ToString.Exclude
    @JoinColumn(name = "level_guid")
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Level level;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private Set<Feedback> feedbacks = new HashSet<>();

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private Set<Score> scores = new HashSet<>();

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private Set<Object> objects = new HashSet<>();

    @ToString.Exclude
    @Builder.Default
    @ManyToMany(mappedBy = "users")
    private Set<State> states = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
