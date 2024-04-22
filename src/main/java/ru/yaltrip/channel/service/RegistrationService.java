package ru.yaltrip.channel.service;

import ru.yaltrip.channel.model.AbstractUserRegistrationDTO;
import ru.yaltrip.channel.model.UserEntrepreneurRegistrationDTO;
import ru.yaltrip.channel.model.UserTouristRegistrationDTO;
import ru.yaltrip.model.AbstractUser;
import ru.yaltrip.model.UserEntrepreneur;
import ru.yaltrip.model.UserTourist;

public interface RegistrationService {
    UserTourist convertToUserTourist(UserTouristRegistrationDTO userTourist);

    UserEntrepreneur convertToUserEntrepreneur(UserEntrepreneurRegistrationDTO userEntrepreneur);

    AbstractUser convertTo(AbstractUserRegistrationDTO user);
}
