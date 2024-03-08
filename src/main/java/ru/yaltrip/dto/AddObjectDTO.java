package ru.yaltrip.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * This class presents {@link ru.yaltrip.model.Object} data transfer object (DTO)
 * for transfer data between application layers.
 * This DTO class needs for transfer data from client when user complete registration {@link ru.yaltrip.model.Object}.
 */
@Data
@Builder
@Schema
public class AddObjectDTO {
    @Schema(name = "accountId",
            title = "Account identifier presents who registration new object",
            type = "String",
            example = "fad53647-1de1-4e64-805d-e8d40c320720")
    private String accountId;

    @Schema(name = "name",
            title = "object name",
            type = "String",
            example = "Ural mountains")
    private String name;

    @Schema(name = "type",
            title = "this field presents object type such 'Cultural heritage site'",
            type = "String",
            example = "Место исторического наследия")
    private String type;

    @Schema(name = "shortDescription",
            title = "object short description",
            type = "String",
            example = """
                    Горная система на Урале, расположенная между
                    Восточно-Европейской и Западно-Сибирской равнинами.
                    """)
    private String shortDescription;

    @Schema(name = "fullDescription",
            title = "object full description",
            type = "String",
            example = """
                    Ура́льские го́ры — горная система на Урале, расположенная между Восточно-Европейской и
                    Западно-Сибирской равнинами. Простирается примерно с севера на юг
                    через западную часть России, от побережья Северного Ледовитого океана
                    до реки Урал и северо-западного Казахстана. Горный массив является
                    частью условной границы между частями света Европой и Азией.
                    """)
    private String fullDescription;

    @Schema(name = "eventStartDate",
            title = "This field contain date when event will be started",
            type = "String",
            example = "2024-01-01T18:25:43-05:00")
    private String eventStartDate;

    @Schema(name = "eventEndDate",
            title = "This field contain date when event will be ended",
            type = "String",
            example = "2024-01-21T18:25:43-05:00")
    private String eventEndDate;

    @Schema(name = "phoneNumber",
            title = "Phone number for contact owner in this event",
            type = "String",
            example = "+79999999999")
    private String phoneNumber;

    @Schema(name = "email",
            title = "email address for contact owner in thi event",
            type = "String",
            example = "example@example.com")
    private String email;

    @Schema(name = "address",
            title = "address where owner place hold",
            type = "String",
            example = "Республика Башкортостан, г. Уфа, ул. 50-летия Октября, 21")
    private String address;

    @Schema(name = "longitude",
            title = "longitude where object placed",
            type = "String",
            example = "59.251903")
    private String longitude;

    @Schema(name = "latitude",
            title = "latitude where object placed",
            type = "String",
            example = "59.455069")
    private String latitude;

    @Schema(name = "photos",
            title = "list photos current object",
            type = "MultipartFile")
    private List<MultipartFile> photos;
}
