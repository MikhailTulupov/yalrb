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
public class LevelDTO implements Serializable {
    @Schema(name = "levelType",
            title = "Contains achievement for the user when they" +
                    " reach a certain level",
            type = "String",
            example = "Stranger")
    private String type;
    @Schema(name = "levelScore",
            title = "Contains level score",
            type = "int",
            example = "0")
    private int score;
}
