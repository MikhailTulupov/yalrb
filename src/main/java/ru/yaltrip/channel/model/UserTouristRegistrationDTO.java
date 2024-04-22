package ru.yaltrip.channel.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class presents {@link ru.yaltrip.model.UserTourist} data transfer object (DTO)
 * for transfer data between application layers.
 * This DTO class needs for transfer data to server when user registration account with tourist role.
 */
@Data
@Schema
@EqualsAndHashCode(callSuper = true)
public class UserTouristRegistrationDTO extends AbstractUserRegistrationDTO {
}
