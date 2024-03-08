package ru.yaltrip.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.yaltrip.dto.AccountDTO;
import ru.yaltrip.dto.AddAccountDTO;
import ru.yaltrip.model.Account;
import ru.yaltrip.model.Object;

/**
 * This interface provides methods for convert dto object {@link AddAccountDTO}
 * to entity (POJO) {@link Account} or entity (POJO) {@link Account} to dto object {@link AccountDTO}.
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mappings({
            @Mapping(target = "account.id", ignore = true),
            @Mapping(target = "account.createdDateTime", ignore = true),
            @Mapping(target = "account.role", ignore = true),
            @Mapping(target = "account.level", ignore = true),
            @Mapping(target = "account.feedbacks", ignore = true),
            @Mapping(target = "account.scores", ignore = true),
            @Mapping(target = "account.objects", ignore = true),
            @Mapping(target = "account.states", ignore = true),
    })
    Account convertToEntity(AddAccountDTO addAccountDTO);

    @Mappings({
            @Mapping(target = "id", source = "account.id"),
            @Mapping(target = "role", source = "account.role.name"),
            @Mapping(target = "levelScore", source = "account.level.score"),
            @Mapping(target = "levelType", source = "account.level.levelType.name"),
            @Mapping(target = "objects", source = "account.objects", qualifiedByName = "mapObject")
    })
    AccountDTO convertToDTO(Account account);

    @Named("mapObject")
    default String mapObject(Object object) {
        return object.getId().toString();
    }
}
