package ru.yltrip.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.yltrip.model.State;
import ru.yltrip.service.StateService;

@Component
public class StateData implements CommandLineRunner {
    final StateService stateService;

    final String STATE_ONLINE = "In Online";
    final String STATE_OFFLINE = "Offline";
    final String STATE_ONLINE_DESCRIPTION = "user in online";
    final String STATE_OFFLINE_DESCRIPTION = "user offline";

    @Autowired
    public StateData(StateService stateService) {
        this.stateService = stateService;
    }

    @Override
    public void run(String... args) {
        State inOnline = State.builder()
                .name(STATE_ONLINE)
                .description(STATE_ONLINE_DESCRIPTION)
                .build();

        State offline = State.builder()
                .name(STATE_OFFLINE)
                .description(STATE_OFFLINE_DESCRIPTION)
                .build();

        stateService.save(inOnline);
        stateService.save(offline);
    }
}
