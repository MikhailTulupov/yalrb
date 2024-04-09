package ru.yaltrip.channel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yaltrip.channel.model.UserEntrepreneurRegistrationDTO;
import ru.yaltrip.channel.model.UserTouristRegistrationDTO;
import ru.yaltrip.dto.SignInRequestDTO;
import ru.yaltrip.mapper.UserEntrepreneurMapper;
import ru.yaltrip.mapper.UserTouristMapper;
import ru.yaltrip.model.UserEntrepreneur;
import ru.yaltrip.model.UserTourist;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    final UserTouristMapper userTouristMapper;
    final UserEntrepreneurMapper userEntrepreneurMapper;

    @Override
    public UserTourist convertToUserTourist(UserTouristRegistrationDTO userTourist) {
        return userTouristMapper.convertToEntity(userTourist);
    }

    @Override
    public UserEntrepreneur convertToUserEntrepreneur(UserEntrepreneurRegistrationDTO userEntrepreneur) {
        return userEntrepreneurMapper.convertToEntity(userEntrepreneur);
    }
}
