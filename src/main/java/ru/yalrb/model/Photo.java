package ru.yalrb.model;

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
@Data
@Builder
@Entity
@RequiredArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_guid")
    private Object object;

    private String path;

    @Column(nullable = true)
    private String name;

    private String type;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date loadedDateTime;
}
