package ru.yaltrip.channel.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class UserEntrepreneurRegistrationDTO {
    @Schema(name = "name",
            title = "First name user",
            type = "String",
            example = "Misha")
    private String name;

    @Schema(name = "phoneNumber",
            title = "phone number",
            type = "String",
            example = "+79999999999")
    private String phoneNumber;

    @Schema(name = "email",
            title = "e-mail",
            type = "String",
            example = "example@example.com")
    private String email;

    @Schema(name = "companyName",
            title = "company name",
            example = "YalTrip")
    private String companyName;

    @Schema(name = "taxpayerNumberId",
            title = "taxpayer identifier number",
            example = "263516479611")
    private String taxpayerNumberId;

    @Schema(name = "password",
            title = "account password",
            example = "qwerty123456")
    private String password;
}