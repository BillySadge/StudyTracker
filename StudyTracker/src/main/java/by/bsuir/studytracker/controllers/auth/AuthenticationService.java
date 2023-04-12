package by.bsuir.studytracker.controllers.auth;


import by.bsuir.studytracker.config.JwtService;
import by.bsuir.studytracker.domain.Role;
import by.bsuir.studytracker.domain.User;
import by.bsuir.studytracker.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

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

        userRepository.save(user);
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userId", user.getId());
//        extraClaims.put("firstName", user.getFirstName());
//        extraClaims.put("lastName", user.getLastName());
        extraClaims.put("hasRole", user.getRole());
        var jwtToken = jwtService.generateToken(extraClaims,user);
        return new AuthenticationResponse(jwtToken);
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
}
