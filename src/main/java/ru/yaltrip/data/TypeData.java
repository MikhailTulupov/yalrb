package ru.yaltrip.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.yaltrip.model.Type;
import ru.yaltrip.repository.TypeRepository;

@Component
public class TypeData implements CommandLineRunner {

    final TypeRepository repository;

    final String TYPE_NAME = "Место исторического наследия";
    final String TYPE_DESCRIPTION = "test";


    @Autowired
    public TypeData(TypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        Type type = Type.builder()
                .name(TYPE_NAME)
                .description(TYPE_DESCRIPTION)
                .build();

        repository.save(type);
    }
}
