package ru.yaltrip.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yaltrip.channel.model.UserEntrepreneurRegistrationDTO;
import ru.yaltrip.channel.model.UserTouristRegistrationDTO;
import ru.yaltrip.channel.service.RegistrationService;
import ru.yaltrip.model.UserEntrepreneur;
import ru.yaltrip.model.UserTourist;
import ru.yaltrip.service.JwtService;
import ru.yaltrip.service.RegistrationUserEntrepreneurService;
import ru.yaltrip.service.RegistrationUserTouristService;
import ru.yaltrip.service.UserTouristService;

/**
 * This controller is designed for registering common
 * users with roles such as tourist or entrepreneur.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    final UserTouristService userTouristService;
    final RegistrationUserTouristService registrationUserTouristService;
    final RegistrationUserEntrepreneurService registrationUserEntrepreneurService;
    final RegistrationService registrationService;
    final JwtService jwtService;

    @Operation(summary = "Registration a new user with role tourist")
    @PostMapping(value = "/tourist",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<String> touristRegistration(@RequestBody
                                                      UserTouristRegistrationDTO userTouristRegistrationDTO) {

        UserTourist userTourist = (UserTourist) registrationService.convertTo(userTouristRegistrationDTO);
        userTourist = registrationUserTouristService.registration(userTourist);
        String token = jwtService.generateToken(userTourist);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/account/" + userTourist.getId());
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @Operation(summary = "Registration a new user with role tourist")
    @PostMapping(value = "/entrepreneur",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<String> entrepreneurRegistration(@RequestBody
                                                           UserEntrepreneurRegistrationDTO userEntrepreneurRegistrationDTO) {
        UserEntrepreneur userEntrepreneur = registrationService.convertToUserEntrepreneur(userEntrepreneurRegistrationDTO);

        userEntrepreneur = registrationUserEntrepreneurService.registration(userEntrepreneur);
        String token = jwtService.generateToken(userEntrepreneur);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/account/" + userEntrepreneur.getId());
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
