package ru.yltrip.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * This class presents {@link ru.yltrip.model.Account} data transfer object (DTO)
 * for transfer data between application layers.
 * This DTO class needs for transfer data to server when user registration account.
 */
@Data
@Schema
public class AddAccountDTO {
    @Schema(name = "login",
            title = "Account username",
            type = "String",
            example = "user-1")
    private String login;

    @Schema(name = "password",
            title = "account password",
            example = "qwerty123456")
    private String password;

    @Schema(name = "phoneNumber",
            title = "phone number",
            type = "String",
            example = "+79999999999")
    private String phoneNumber;
}
