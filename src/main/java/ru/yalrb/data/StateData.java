package ru.yalrb.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.yalrb.model.State;
import ru.yalrb.service.StateService;

@Component
public class StateData implements CommandLineRunner {

    @Autowired
    StateService stateService;

    private State inOnline;
    private State offline;

    @Override
    public void run(String... args) throws Exception {
        inOnline = State.builder()
                .name("In Online")
                .description("user in online")
                .build();

        offline = State.builder()
                .name("Offline")
                .description("user offline")
                .build();

        stateService.save(inOnline);
        stateService.save(offline);
    }
}
