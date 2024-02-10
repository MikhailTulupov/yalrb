package ru.yalrb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

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
