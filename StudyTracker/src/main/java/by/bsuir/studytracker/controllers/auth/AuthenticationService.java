package by.bsuir.studytracker.controllers.auth;


import by.bsuir.studytracker.config.JwtService;
import by.bsuir.studytracker.domain.Role;
import by.bsuir.studytracker.domain.User;
import by.bsuir.studytracker.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public static final String EMAIL_REGEX_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse register(RegisterRequest request) {

        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Role.USER
        );
        try {
            userRepository.save(user);
            Map<String, Object> extraClaims = new HashMap<>();
            extraClaims.put("userId", user.getId());
            extraClaims.put("hasRole", user.getRole());
            var jwtToken = jwtService.generateToken(extraClaims, user);
            return new AuthenticationResponse(jwtToken);
        }catch (DataIntegrityViolationException e){
            return null;
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userId", user.getId());
//        extraClaims.put("firstName", user.getFirstName());
//        extraClaims.put("lastName", user.getLastName());
        extraClaims.put("role", user.getRole());
        var jwtToken = jwtService.generateToken(extraClaims,user);
//        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }


    public boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
    public boolean isEmailValid(String emailAddress) {
        return patternMatches(emailAddress, EMAIL_REGEX_PATTERN);
    }
}
