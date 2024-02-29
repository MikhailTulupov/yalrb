package ru.yalrb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.yalrb.dto.AccountDTO;
import ru.yalrb.dto.LevelDTO;
import ru.yalrb.model.Account;
import ru.yalrb.model.Level;
import ru.yalrb.model.LevelType;
import ru.yalrb.model.Role;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "accountDTO.id"),
            @Mapping(target = "createdDateTime", source = "accountDTO.createdDateTime"),
            @Mapping(target = "role",
                    source = "accountDTO.role",
                    qualifiedByName = "mapRole"),
            @Mapping(target = "level",
                    source = "accountDTO.level",
                    qualifiedByName = "mapLevel"
            )})
    Account convertToEntity(AccountDTO accountDTO);

    @Mappings({
            @Mapping(target = "role",
                    source = "account.role",
                    qualifiedByName = "mapRoleToString"),
            @Mapping(target = "level",
                    source = "account.level",
                    qualifiedByName = "mapLevelToDTO")
    })
    AccountDTO convertToDTO(Account account);

    @Named("mapLevelToDTO")
    default LevelDTO mapLevelTypeToString(Level level) {
        return LevelDTO.builder()
                .type(level.getLevelType().getName())
                .score(level.getScore())
                .build();
    }

    @Named("mapRoleToString")
    default String mapRoleToString(Role role) {
        return role.getName();
    }

    @Named("mapRole")
    default Role mapRole(String role) {
        return Role.builder().name(role).build();
    }

    @Named("mapLevel")
    default Level mapLevel(LevelDTO levelDTO) {
        return Level.builder().
                score(levelDTO.getScore()).
                levelType(LevelType.builder()
                        .name(levelDTO.getType())
                        .build())
                .build();
    }
}
