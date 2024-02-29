package ru.yalrb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@Schema
public class AccountDTO implements Serializable {
    @Schema(name = "id",
            title = "User identifier",
            type = "UUID",
            examples = {"null", "fad53647-1de1-4e64-805d-e8d40c320720"})
    private String id;
    @Schema(name = "login",
            title = "Account name",
            type = "String",
            example = "user-1")
    private String login;
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
    private String role;

    private LevelDTO level;
}
