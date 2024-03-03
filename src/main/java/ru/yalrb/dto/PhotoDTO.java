package ru.yalrb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhotoDTO {
    private byte[] image;
}
