package ru.yaltrip.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.yaltrip.model.UserTourist;

/**
 * This interface provides a methods for manipulating {@link UserTourist} data.
 */
public interface UserTouristService extends CrudService<UserTourist> {
    /**
     * Getting a user by phoneNumber.
     *
     * @param phoneNumber phoneNumber
     * @return {@link UserTourist}
     */
    UserTourist getByPhoneNumber(String phoneNumber);

    /**
     * Getting a user-specific data.
     *
     * @return {@link UserTouristService}
     */
    UserDetailsService userDetailsService();

    /**
     * Take current user.
     *
     * @return current user
     */
    UserTourist getCurrentUser();
}
