package ru.yaltrip.model;

import jakarta.persistence.Entity;
import lombok.*;

/**
 * This class is a data model of the YalTrip service.
 * It is inherited from the {@link AbstractUser} base class and
 * represents a regular user of the site with the role of a tourist.
 * A tourist can leave a review on an object, rate it, comment on it
 * or rate it, search for an object, add objects to favorites, and so on.
 */
@AllArgsConstructor
@Builder(access = AccessLevel.PROTECTED)
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserTourist extends AbstractUser {
}
