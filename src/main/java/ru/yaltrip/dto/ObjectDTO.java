package ru.yaltrip.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * This class presents {@link Object} data transfer object (DTO)
 * for transfer data between application layers.
 * This DTO class needs for transfer data from server when user complete registration object or open
 * site page with object.
 */
@Data
@Builder
@Schema
public class ObjectDTO {
    @Schema(name = "id",
            title = "Object identifier",
            type = "String",
            examples = "fad53647-1de1-4e64-805d-e8d40c320720")
    private String id;

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
                    горная система на Урале, расположенная между
                    Восточно-Европейской и Западно-Сибирской равнинами
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
                    Остров Вайгач и острова Новая Земля образуют дальнейшее продолжение горной цепи
                    на север в Северном Ледовитом океане. Уральский экономический район имеет
                    богатые ресурсы, в том числе металлические руды, уголь, а также драгоценные
                    и полудрагоценные камни. С XVIII века он внёс значительный вклад в
                    минеральную отрасль российской экономики.
                                
                    Длина составляет более 2000 километров (с Пай-Хоем и Мугоджарами — более 2600 километров[3]),
                    ширина — от 40 до 150 километров.
                    """)
    private String fullDescription;

    @Schema(name = "eventStartDate",
            title = "This field contain date when event will be started",
            type = "String",
            example = "2024-01-01T18:25:43-05:00")
    private String eventStartDate;

    @Schema(name = "eventStartDate",
            title = "This field contain date when event will be started",
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
            title = "list URLs photos current object",
            type = "String")
    private List<String> photos;
}
