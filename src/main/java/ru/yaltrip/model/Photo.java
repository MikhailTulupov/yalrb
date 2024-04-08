package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 * This class is a data model of the YalTrip service. It complements the {@link Object} model.
 * This model is a photo of an object. This model does not contain the photo itself,
 * but only the place where this photo is stored in the file storage, the name,
 * the type of photo (jpeg or png) and the time when the photo was uploaded to the site.
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
