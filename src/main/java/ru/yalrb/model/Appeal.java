package ru.yalrb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 * This class represents entity {@link Appeal} for providing an opportunity leave appeal to moderators.
 * This entity {@link Appeal} have many relationships with others entities:
 * {@link Account} user, {@link AppealState} and {@link Account} moderator.
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@RequiredArgsConstructor
public class Appeal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_guid")
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appeal_state_guid")
    private AppealState appealState;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moderator_guid")
    private Account moderator;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false)
    private String appealText;

    @Column(nullable = false)
    private Date appealDateTime;

    private String responseText;

    private Date responseDateTime;
}
