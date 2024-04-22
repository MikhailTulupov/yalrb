package ru.yaltrip.channel.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.yaltrip.model.AbstractUser;

/**
 * This abstract class presents {@link AbstractUser} data transfer object (DTO)
 * for transfer data between application layers.
 * This DTO class needs for transfer data to server when user registration account.
 */
@Data
@Schema
public abstract class AbstractUserRegistrationDTO {
    @Schema(name = "name",
            title = "First name user",
            type = "String",
            example = "Misha")
    protected String name;

    @Schema(name = "phoneNumber",
            title = "phone number",
            type = "String",
            example = "+79999999999")
    protected String phoneNumber;

    @Schema(name = "email",
            title = "e-mail",
            type = "String",
            example = "example@example.com")
    protected String email;

    @Schema(name = "password",
            title = "account password",
            example = "qwerty123456")
    protected String password;
}
