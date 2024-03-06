package ru.yltrip.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.yltrip.model.LevelType;
import ru.yltrip.service.LevelTypeService;

/**
 * This class implements {@link CommandLineRunner} interface which helps
 * initialize the initial database data for the application.
 */
@Component
public class LevelTypeData implements CommandLineRunner {
    private final LevelTypeService levelTypeService;
    final String LEVEL_TYPE_NAME_STRANGER = "Stranger";
    final String LEVEL_TYPE_DESCRIPTION_STRANGER = """
            A newly registered user
            """;
    final String LEVEL_TYPE_NAME_GOD = "God";
    final String LEVEL_TYPE_DESCRIPTION_GOD = "The service administrator";

    @Autowired
    public LevelTypeData(LevelTypeService levelTypeService) {
        this.levelTypeService = levelTypeService;
    }

    @Override
    public void run(String... args) {

        LevelType stranger = LevelType.builder()
                .name(LEVEL_TYPE_NAME_STRANGER)
                .description(LEVEL_TYPE_DESCRIPTION_STRANGER)
                .build();

        LevelType god = LevelType.builder()
                .name(LEVEL_TYPE_NAME_GOD)
                .description(LEVEL_TYPE_DESCRIPTION_GOD)
                .build();

        levelTypeService.save(stranger);
        levelTypeService.save(god);
    }
}
