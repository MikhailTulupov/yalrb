package ru.yaltrip;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.yaltrip.model.Object;
import ru.yaltrip.model.*;
import ru.yaltrip.repository.*;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = YalTripApplication.class)
public class EntityRelationshipTests {
    @Autowired
    ObjectRepository objectRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    RateRepository rateRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    LevelRepository levelRepository;

    @Autowired
    LevelTypeRepository levelTypeRepository;

    Object object;
    Account account;
    Role role;
    Level level;
    LevelType levelType;
    Type type;
    Contact contact;
    Location location;
    State stateWork;
    State stateConfirm;
    State stateRegistry;

    @AfterEach
    void destroyAll() {

    }

    @BeforeEach
    void initData() {
        role = Role.builder()
                .name("moderator")
                .description("moderator")
                .build();

        levelType = LevelType.builder()
                .name("Stranger")
                .description("Test")
                .build();

        level = Level.builder()
                .score(0)
                .levelType(levelType)
                .build();

        account = Account.builder()
                .login("admin")
                .password("admin")
                .level(level)
                .createdDateTime(new Date())
                .role(role)
                .build();

        type = Type.builder()
                .name("Объект культурного наследия")
                .description("Test")
                .build();

        contact = Contact.builder()
                .phoneNumber("+79999999999")
                .name("Bob")
                .email("example@example.com")
                .address("Backer street")
                .build();

        location = Location.builder()
                .latitude(123.456f)
                .latitude(123.456f)
                .build();

        stateRegistry = State.builder()
                .name("Registry")
                .description("test")
                .build();

        stateConfirm = State.builder()
                .name("Confirm")
                .description("Test")
                .build();

        stateWork = State.builder()
                .name("Work")
                .description("Test")
                .build();

        object = Object.builder()
                .account(account)
                .type(type)
                .contact(contact)
                .location(location)
                .states(Set.of(stateConfirm, stateRegistry, stateWork))
                .name("Yfa")
                .shortDescription("test")
                .fullDescription("test")
                .build();

        roleRepository.save(role);
        accountRepository.save(account);
        typeRepository.save(type);
        stateRepository.save(stateRegistry);
        stateRepository.save(stateWork);
        stateRepository.save(stateConfirm);
        objectRepository.save(object);
    }

    @Test
    void entityRelationTest() {
        Optional<Object> byId = objectRepository.findById(object.getId());
        byId.ifPresent(value -> Assertions.assertEquals(object.getId(), value.getId()));
    }
}
