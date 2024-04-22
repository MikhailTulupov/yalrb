package ru.yaltrip.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import ru.yaltrip.model.AbstractUser;

import java.util.List;

/**
 * This class presents {@link AbstractUser} data transfer object (DTO)
 * for transfer data between application layers.
 * This DTO class needs for transfer data from server when user complete registration or log in.
 */
@Builder
@Data
@Schema
public class SignInRequestDTO {
    @Schema(name = "id",
            title = "User identifier",
            type = "UUID",
            examples = "fad53647-1de1-4e64-805d-e8d40c320720")
    private String id;
    @Schema(name = "name",
            title = "User name",
            type = "String",
            example = "Dmitry")
    private String name;
    @Schema(name = "password",
            title = "Account password",
            type = "String",
            example = "qwerty123456")
    private String password;
    @Schema(name = "phoneNumber",
            title = "User phone number",
            type = "String",
            example = "+79968177277")
    private String phoneNumber;
    @Schema(name = "createdDateTime",
            title = "Account creation date",
            type = "Date",
            example = "2024-02-28T06:51:27.938+00:00")
    private String createdDateTime;
    @Schema(name = "role",
            title = "User privileges. There can be only" +
                    " one of two privileges 'user' or 'admin'",
            type = "String",
            examples = {"User", "Admin"})
    private List<String> role;
}
