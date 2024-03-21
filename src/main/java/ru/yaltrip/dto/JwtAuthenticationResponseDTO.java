package ru.yaltrip.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.yaltrip.model.User;

/**
 * This class presents JWT token data transfer object (DTO)
 * for transfer data between application layers.
 * This DTO class needs for transfer token from server to frontend.
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Schema(description = "Response with access token")
public class JwtAuthenticationResponseDTO {
    private String token;
}
