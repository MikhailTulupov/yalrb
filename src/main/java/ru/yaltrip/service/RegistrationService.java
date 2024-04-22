package ru.yaltrip.service;

import ru.yaltrip.model.AbstractUser;

public interface RegistrationService {
    /**
     * Registration user.
     *
     * @param user user data
     * @return user
     */
    AbstractUser registration(AbstractUser user);
}
