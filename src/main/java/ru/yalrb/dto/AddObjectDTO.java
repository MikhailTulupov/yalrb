package ru.yalrb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Schema
public class AddObjectDTO {
    private String accountId;
    private String name;
    private String type;
    private String shortDescription;
    private String fullDescription;
    private String eventStartDate;
    private String eventEndDate;
    private String phoneNumber;
    private String email;
    private String address;
    private String longitude;
    private String latitude;
    private List<MultipartFile> photos = new ArrayList<>();
}
