package by.bsuir.studytracker.demo;

import by.bsuir.studytracker.exception.UserNotFoundException;
import by.bsuir.studytracker.domain.User;
import by.bsuir.studytracker.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello from admin dashboard secured endpoint");
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return repository.findAll();
    }

    @PostMapping("/users")
    User newEmployee(@RequestBody User newUser) {

        User user = new User(
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword()),
                newUser.getRole()
        );
        return repository.save(user);
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(passwordEncoder.encode(newUser.getPassword()));
                    user.setRole(newUser.getRole());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
