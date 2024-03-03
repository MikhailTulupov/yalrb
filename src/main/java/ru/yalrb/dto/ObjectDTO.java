package ru.yalrb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import ru.yalrb.model.Photo;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Schema
public class ObjectDTO {
//    private String id;
    private String name;
    private String shortDescription;
    private String fullDescription;
//    private String eventStartDate;
//    private String eventEndDate;
//    private String accountId;
//    private String type;
//    private ContactDTO contacts;
//    private LocationDTO location;
    private Set<MultipartFile> photos = new HashSet<>();
}
