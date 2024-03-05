package ru.yalrb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.yalrb.dto.AddObjectDTO;
import ru.yalrb.dto.ObjectDTO;
import ru.yalrb.model.Object;
import ru.yalrb.model.Photo;

@Mapper
public interface ObjectMapper {
    @Mappings({
            @Mapping(target = "accountId",
                    source = "object.account.id"),
            @Mapping(target = "type",
                    source = "object.type.name"),
            @Mapping(target = "phoneNumber",
                    source = "object.contact.phoneNumber"),
            @Mapping(target = "address",
                    source = "object.contact.address"),
            @Mapping(target = "email",
                    source = "object.contact.email"),
            @Mapping(target = "longitude",
                    source = "object.location.longitude"),
            @Mapping(target = "latitude",
                    source = "object.location.latitude"),
            @Mapping(target = "photos",
            source = "object.photos",
            qualifiedByName = "mapPhoto"),
            @Mapping(target = "object.rate", ignore = true),
            @Mapping(target = "object.feedbacks", ignore = true),
            @Mapping(target = "object.states", ignore = true)
    })
    ObjectDTO convertToDTO(Object object);

    @Mappings({
            @Mapping(target = "account.id",
                    source = "addObjectDTO.accountId"),
            @Mapping(target = "type.name",
                    source = "addObjectDTO.type"),
            @Mapping(target = "contact.phoneNumber",
                    source = "addObjectDTO.phoneNumber"),
            @Mapping(target = "contact.email",
                    source = "addObjectDTO.email"),
            @Mapping(target = "contact.address",
                    source = "addObjectDTO.address"),
            @Mapping(target = "location.longitude",
                    source = "addObjectDTO.longitude"),
            @Mapping(target = "location.latitude",
                    source = "addObjectDTO.latitude"),
            @Mapping(target = "photos", ignore = true),
            @Mapping(target = "object.rate", ignore = true),
            @Mapping(target = "object.feedbacks", ignore = true),
            @Mapping(target = "object.states", ignore = true)
    })
    Object convertToEntity(AddObjectDTO addObjectDTO);

    @Named("mapPhoto")
    default String mapPhoto(Photo photo) {
        return photo.getPath();
    }
}
