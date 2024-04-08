package ru.yaltrip.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.yaltrip.model.UserTourist;
import ru.yaltrip.repository.UserTouristRepository;
import ru.yaltrip.service.UserTouristService;

import java.util.Date;

/**
 * This class implements {@link UserTouristService} interface methods.
 */
@Service
@RequiredArgsConstructor
public class UserTouristServiceImpl implements UserTouristService {

    private final UserTouristRepository userTouristRepository;

    /**
     * User save in repository.
     *
     * @param entity user
     * @return saved user
     */
    @Override
    public UserTourist save(UserTourist entity) {

        if (userTouristRepository.existsByPhoneNumber(entity.getPhoneNumber())) {
            throw new RuntimeException("A user with that phone number already exists");
        }

        entity.setCreatedDateTime(new Date());

        return userTouristRepository.save(entity);
    }

    @Override
    public UserTourist getByPhoneNumber(String phoneNumber) {
        return userTouristRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User don't found"));
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::getByPhoneNumber;
    }

    @Override
    public UserTourist getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return getByPhoneNumber(userDetails.getUsername());
    }
}
