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

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "object_guid")
    private Object object;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private byte[] image;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Date loadedDateTime;
}
