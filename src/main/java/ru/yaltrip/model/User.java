package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is an abstract data model of the YalTrip service.
 * It is the base class for implementing {@link User} roles such as
 * tourist, entrepreneur, moderator or administrator.
 * This model represents all the basic fields required by the user.
 * This class also implements the {@link UserDetails} interface,
 * which is a necessary part of the Spring Security framework,
 * to authenticate the user and grant the user the necessary
 * privileges and rights, depending on his role.
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@EqualsAndHashCode(exclude = {"roles"})
@ToString(exclude = {"phoneNumber", "email", "password"})
public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    protected UUID id;

    @Column(nullable = false)
    protected String name;

    @Column(unique = true)
    protected String phoneNumber;

    @Column(unique = true)
    protected String email;

    @Column(nullable = false)
    protected String password;


    @Column(nullable = false)
    protected Date createdDateTime;

    @Builder.Default
    @ElementCollection(targetClass = Role.class,
            fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles",
            joinColumns =
            @JoinColumn(name = "user_guid"))
    @Enumerated(EnumType.STRING)
    protected Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toSet());
    }

    /**
     * Returns the phone number used to authenticate the user.
     * Cannot return null.
     * @return phone Number
     */
    @Override
    public String getUsername() {
        return phoneNumber;
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
