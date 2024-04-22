package ru.yaltrip.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.yaltrip.channel.model.UserEntrepreneurRegistrationDTO;
import ru.yaltrip.channel.model.UserTouristRegistrationDTO;
import ru.yaltrip.dto.SignInRequestDTO;
import ru.yaltrip.model.UserEntrepreneur;
import ru.yaltrip.model.UserTourist;

@Mapper(componentModel = "spring")
public interface UserEntrepreneurMapper {
    /**
     * Mapping {@link UserTouristRegistrationDTO} transfer model to POJO {@link UserTourist}
     *
     * @param userEntrepreneurRegistrationDTO data transfer model
     * @return POJO entity
     */
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdDateTime", ignore = true),
            @Mapping(target = "roles", ignore = true),
    })
    UserEntrepreneur convertToEntity(UserEntrepreneurRegistrationDTO userEntrepreneurRegistrationDTO);

    /**
     * Mapping {@link UserTourist} java entity to data transfer model {@link SignInRequestDTO}
     *
     * @param user entity
     * @return data transfer model
     */
    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "role", source = "user.roles"),
    })
    SignInRequestDTO convertToDTO(UserTourist user);
}
