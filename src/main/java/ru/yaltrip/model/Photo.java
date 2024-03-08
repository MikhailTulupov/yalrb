package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 * This class represents entity {@link Photo} it`s dependent of entity {@link Object}, it`s represents image,
 * witch user can load to {@link Object} and display on site.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@RequiredArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date loadedDateTime;

    @JoinColumn(name = "object_guid")
    @ManyToOne(fetch = FetchType.EAGER)
    private Object object;
}
