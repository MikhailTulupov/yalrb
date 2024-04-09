package ru.yaltrip.service;

import ru.yaltrip.model.UserEntrepreneur;

public interface RegistrationUserEntrepreneurService {
    /**
     * Registration user.
     *
     * @param user user data
     * @return token
     */
    UserEntrepreneur registration(UserEntrepreneur user);
}
