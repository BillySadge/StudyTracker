package by.bsuir.studytracker.controllers.auth;

import by.bsuir.studytracker.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request
    ){
        if (service.isEmailValid(request.getEmail())){
            var registeredUser = service.register(request);

            if(registeredUser == null)
            {
                String errorMessage = "User with this email address already exists";
                return ResponseEntity.badRequest().body(errorMessage);
            }
            else{
                return ResponseEntity.ok(registeredUser);

            }
        }else{
            String errorMessage = "Invalid email address";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));

    }

}
