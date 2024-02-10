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
@EqualsAndHashCode(exclude = {"feedbacks", "photos", "states"})
@RequiredArgsConstructor
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_guid")
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_guid")
    private Type type;


    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_guid")
    private Contact contact;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rate_guid")
    private Rate rate;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "location_guid")
    private Location location;

    @OneToMany(mappedBy = "object")
    @Builder.Default
    @ToString.Exclude
    private Set<Feedback> feedbacks = new HashSet<>();


    @OneToMany(mappedBy = "object")
    @Builder.Default
    @ToString.Exclude
    private Set<Photo> photos = new HashSet<>();

    @ManyToMany(mappedBy = "objects",
            cascade = CascadeType.MERGE)
    @Builder.Default
    @ToString.Exclude
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
