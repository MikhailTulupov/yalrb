package ru.yalrb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@Entity
@RequiredArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @OneToOne(mappedBy = "location")
    private Object object;

    @Column(nullable = false)
    private float longitude;

    @Column(nullable = false)
    private float latitude;
}
