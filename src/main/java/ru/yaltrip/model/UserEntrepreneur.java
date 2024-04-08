package ru.yaltrip.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is a data model of the YalTrip service.
 * It is inherited from the {@link User} base class and
 * represents a regular user of the site with the role of an entrepreneur.
 * An entrepreneur is given slightly more privileges than a tourist user.
 * For example, it can create new objects that a regular user cannot.
 */
@AllArgsConstructor
@Builder(access = AccessLevel.PROTECTED)
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"objects"})
@ToString(callSuper = true, exclude = {"objects"})
public class UserEntrepreneur extends User {
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private Set<Object> objects = new HashSet<>();
}
