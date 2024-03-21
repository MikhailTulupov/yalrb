package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * This class represents entity {@link Object} this entity is the main in this project, and it
 * represents itself as some object where something will happen in real life, for example,
 * such a place may be an object of cultural heritage. This entity {@link Object} have many
 * relationships with others entities: {@link User}, {@link Type}, {@link Contact},
 * {@link Rate}, {@link Location}, {@link Feedback}, {@link Photo} and {@link State}.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(exclude = {"feedbacks", "photos", "states",
        "user", "type", "contact", "location", "rate"})
@RequiredArgsConstructor
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ToString.Exclude
    @JoinColumn(name = "account_guid")
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private User user;

    @Column(nullable = false)
    private String name;

    @ToString.Exclude
    @JoinColumn(name = "type_guid")
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private Type type;

    @Column(nullable = false)
    private String shortDescription;

    @Column(nullable = false, length = 500)
    private String fullDescription;

    private Date eventStartDate;

    private Date eventEndDate;

    @ToString.Exclude
    @JoinColumn(name = "contact_guid")
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Contact contact;

    @ToString.Exclude
    @JoinColumn(name = "location_guid")
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Location location;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "object",
            cascade = CascadeType.ALL)
    private Set<Photo> photos = new HashSet<>();

    @ToString.Exclude
    @JoinColumn(name = "rate_guid")
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Rate rate;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "object",
            cascade = CascadeType.ALL)
    private Set<Feedback> feedbacks = new HashSet<>();

    @Builder.Default
    @ToString.Exclude
    @ManyToMany(mappedBy = "objects",
            cascade = CascadeType.ALL)
    private Set<State> states = new HashSet<>();
}
