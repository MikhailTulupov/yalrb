package ru.yaltrip.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.yaltrip.channel.model.UserTouristRegistrationDTO;
import ru.yaltrip.dto.SignInRequestDTO;
import ru.yaltrip.model.AbstractUser;
import ru.yaltrip.model.UserTourist;

/**
 * This interface provides methods for convert dto object {@link UserTouristRegistrationDTO}
 * to entity (POJO) {@link AbstractUser} or entity (POJO) {@link AbstractUser} to dto object {@link SignInRequestDTO}.
 */
@Mapper(componentModel = "spring")
public interface UserTouristMapper {
    /**
     * Mapping {@link UserTouristRegistrationDTO} transfer model to POJO {@link ru.yaltrip.model.UserTourist}
     *
     * @param signInRequestDTO data transfer model
     * @return POJO entity
     */
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdDateTime", ignore = true),
            @Mapping(target = "roles", ignore = true),
    })
    UserTourist convertToEntity(UserTouristRegistrationDTO signInRequestDTO);

    /**
     * Mapping {@link ru.yaltrip.model.UserTourist} java entity to data transfer model {@link SignInRequestDTO}
     *
     * @param user entity
     * @return data transfer model
     */
    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "role", source = "user.roles"),
    })
    SignInRequestDTO convertToDTO(ru.yaltrip.model.UserTourist user);
}
