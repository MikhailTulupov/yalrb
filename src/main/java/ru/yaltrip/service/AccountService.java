package ru.yaltrip.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.yaltrip.model.User;

/**
 * This interface provides a methods for manipulating {@link User} data.
 */
public interface AccountService extends CrudService<User> {
    /**
     * Getting a user by username.
     *
     * @param username username
     * @return {@link User}
     */
    User getByUserName(String username);

    /**
     * Getting a user by username.
     * <p>
     * Need for Spring Security
     * </p>
     *
     * @return {@link User}
     */
    UserDetailsService userDetailsService();

    /**
     * Take current user.
     *
     * @return current user
     */
    User getCurrentUser();
}
