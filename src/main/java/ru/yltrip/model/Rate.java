package ru.yltrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * This class represents entity {@link Rate} it`s dependent of {@link Object} it`s represent rate this object.
 */
@AllArgsConstructor
@Data
@Builder
@Entity
@RequiredArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @OneToOne(mappedBy = "rate")
    private Object object;

    private int rateFromSite;

    private int rateFromLocation;

    private int rateFromSocialNetwork;
}
