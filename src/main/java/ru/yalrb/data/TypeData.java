package ru.yalrb.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import ru.yalrb.model.Type;
import ru.yalrb.repository.TypeRepository;

public class TypeData implements CommandLineRunner {

    @Autowired
    TypeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Type type = Type.builder()
                .name("Место исторического наследия")
                .description("test")
                .build();

        repository.save(type);
    }
}
