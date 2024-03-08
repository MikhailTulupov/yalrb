package ru.yaltrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 * This class represents entity {@link Feedback}. Class {@link Feedback} providing opportunity
 * to user leave feedback to {@link Object}. This entity have many relationships with others entities:
 * {@link Account} and {@link Object}.
 */
@AllArgsConstructor
@Data
@Builder
@Entity
@RequiredArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_guid")
    private Object object;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_guid")
    private Account account;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date createdDateTime;
}
