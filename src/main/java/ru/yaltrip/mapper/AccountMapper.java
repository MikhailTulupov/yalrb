package ru.yaltrip.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.yaltrip.dto.SignInRequestDTO;
import ru.yaltrip.dto.SignUpRequestDTO;
import ru.yaltrip.model.User;
import ru.yaltrip.model.Object;

/**
 * This interface provides methods for convert dto object {@link SignUpRequestDTO}
 * to entity (POJO) {@link User} or entity (POJO) {@link User} to dto object {@link SignInRequestDTO}.
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mappings({
            @Mapping(target = "user.id", ignore = true),
            @Mapping(target = "user.createdDateTime", ignore = true),
            @Mapping(target = "user.role", ignore = true),
            @Mapping(target = "user.level", ignore = true),
            @Mapping(target = "user.feedbacks", ignore = true),
            @Mapping(target = "user.scores", ignore = true),
            @Mapping(target = "user.objects", ignore = true),
            @Mapping(target = "user.states", ignore = true),
    })
    User convertToEntity(SignUpRequestDTO signUpRequestDTO);

    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "role", source = "user.role"),
            @Mapping(target = "levelScore", source = "user.level.score"),
            @Mapping(target = "levelType", source = "user.level.levelType.name"),
            @Mapping(target = "objects", source = "user.objects", qualifiedByName = "mapObject")
    })
    SignInRequestDTO convertToDTO(User user);

    @Named("mapObject")
    default String mapObject(Object object) {
        return object.getId().toString();
    }
}
