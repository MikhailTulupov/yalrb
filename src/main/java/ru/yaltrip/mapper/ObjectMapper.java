package ru.yaltrip.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.yaltrip.dto.AddObjectDTO;
import ru.yaltrip.dto.ObjectDTO;
import ru.yaltrip.model.Object;
import ru.yaltrip.model.Photo;

/**
 * This interface provides methods for convert dto object {@link AddObjectDTO}
 * to entity (POJO) {@link Object} or entity (POJO) {@link Object} to dto object {@link ObjectDTO}.
 */
@Mapper
public interface ObjectMapper {
    /**
     * Mapping {@link Object} java class to data transfer model {@link ObjectDTO}
     *
     * @param object object
     * @return data transfer model
     */
    @Mappings({
            @Mapping(target = "accountId", source = "object.user.id"),
            @Mapping(target = "type", source = "object.type.name"),
            @Mapping(target = "phoneNumber", source = "object.contact.phoneNumber"),
            @Mapping(target = "address", source = "object.contact.address"),
            @Mapping(target = "email", source = "object.contact.email"),
            @Mapping(target = "longitude", source = "object.location.longitude"),
            @Mapping(target = "latitude", source = "object.location.latitude"),
            @Mapping(target = "photos", source = "object.photos", qualifiedByName = "mapPhoto"),
            @Mapping(target = "object.rate", ignore = true),
    })
    ObjectDTO convertToDTO(Object object);

    /**
     * Mapping {@link AddObjectDTO} transfer model to POJO {@link Object}
     *
     * @param addObjectDTO data transfer model
     * @return POJO entity
     */
    @Mappings({
            @Mapping(target = "user.id", source = "addObjectDTO.accountId"),
            @Mapping(target = "type.name", source = "addObjectDTO.type"),
            @Mapping(target = "contact.phoneNumber", source = "addObjectDTO.phoneNumber"),
            @Mapping(target = "contact.email", source = "addObjectDTO.email"),
            @Mapping(target = "contact.address", source = "addObjectDTO.address"),
            @Mapping(target = "location.longitude", source = "addObjectDTO.longitude"),
            @Mapping(target = "location.latitude", source = "addObjectDTO.latitude"),
            @Mapping(target = "photos", ignore = true),
            @Mapping(target = "object.rate", ignore = true),
    })
    Object convertToEntity(AddObjectDTO addObjectDTO);

    /**
     * Custom mapper for photo field
     * @param photo photo
     * @return path where placed photo
     */
    @Named("mapPhoto")
    default String mapPhoto(Photo photo) {
        return photo.getPath();
    }
}
