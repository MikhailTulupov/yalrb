package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * This class is a data model of the YalTrip service. This model is the main essence of the service,
 * and it represents an object or place where, for example, a sanatorium, hotel, recreation center,
 * cultural attraction or natural landmark is located. Other models depend on this model ({@link Contact},
 * {@link Location}, {@link Photo}, {@link Rate})
 * and other service models interact with it ({@link AbstractUser}, {@link Type}).
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(exclude = {"photos", "user", "type", "contact", "location", "rate"})
@ToString(exclude = {"user", "type", "contact", "location", "photos", "rate"})
@RequiredArgsConstructor
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @JoinColumn(name = "user_guid")
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private UserEntrepreneur user;

    @Column(nullable = false)
    private String name;

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

    @JoinColumn(name = "contact_guid")
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Contact contact;

    @JoinColumn(name = "location_guid")
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Location location;

    @Builder.Default
    @OneToMany(mappedBy = "object",
            cascade = CascadeType.ALL)
    private Set<Photo> photos = new HashSet<>();

    @JoinColumn(name = "rate_guid")
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Rate rate;
}
