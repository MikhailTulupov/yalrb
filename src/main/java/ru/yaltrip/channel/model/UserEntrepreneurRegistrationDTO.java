package ru.yaltrip.channel.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class presents {@link ru.yaltrip.model.UserEntrepreneur} data transfer object (DTO)
 * for transfer data between application layers.
 * This DTO class needs for transfer data to server when user registration account with entrepreneur role.
 */
@Data
@Schema
@EqualsAndHashCode(callSuper = true)
public class UserEntrepreneurRegistrationDTO extends AbstractUserRegistrationDTO{
    @Schema(name = "companyName",
            title = "company name",
            example = "YalTrip")
    private String companyName;

    @Schema(name = "taxpayerNumberId",
            title = "taxpayer identifier number",
            example = "263516479611")
    private String taxpayerNumberId;
}
