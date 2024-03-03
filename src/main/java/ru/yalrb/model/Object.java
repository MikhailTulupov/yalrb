package ru.yalrb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * relationships with others entities: {@link Account}, {@link Type}, {@link Contact},
 * {@link Rate}, {@link Location}, {@link Feedback}, {@link Photo} and {@link State}.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(exclude = {"feedbacks", "photos", "states"})
@RequiredArgsConstructor
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_guid")
    @JsonBackReference(value = "account-objects")
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_guid")
    @JsonIgnore
    private Type type;


    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_guid")
    @JsonIgnore
    private Contact contact;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rate_guid")
    @JsonIgnore
    private Rate rate;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "location_guid")
    @JsonIgnore
    private Location location;

    @OneToMany(mappedBy = "object")
    @Builder.Default
    @ToString.Exclude
    @JsonIgnore
    private Set<Feedback> feedbacks = new HashSet<>();


    @OneToMany(mappedBy = "object",
            cascade = CascadeType.ALL)
    @Builder.Default
    @ToString.Exclude
    @JsonIgnore
    private Set<Photo> photos = new HashSet<>();

    @ManyToMany(mappedBy = "objects",
            cascade = CascadeType.MERGE)
    @Builder.Default
    @ToString.Exclude
    @JsonIgnore
    private Set<State> states = new HashSet<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String shortDescription;

    @Column(nullable = false)
    private String fullDescription;

    private Date eventStartDate;

    private Date eventEndDate;
}
