package ru.yalrb.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.yalrb.model.LevelType;
import ru.yalrb.service.LevelTypeService;

@Component
public class DataLevelType implements CommandLineRunner {

    @Autowired
    private LevelTypeService levelTypeService;
    private LevelType stranger;
    private LevelType god;

    @Override
    public void run(String... args) throws Exception {
        stranger = LevelType.builder()
                .name("Stranger")
                .description("A newly registered user.")
                .build();

        god = LevelType.builder()
                .name("God")
                .description("The service administrator")
                .build();

        levelTypeService.save(stranger);
        levelTypeService.save(god);
    }
}
