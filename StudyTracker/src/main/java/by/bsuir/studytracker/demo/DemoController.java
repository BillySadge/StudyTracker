package by.bsuir.studytracker.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo-controller")
public class DemoController {


    @GetMapping
//    @PreAuthorize(value = "hasClaim('role', 'ADMIN')")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello from secured endpoint");
    }



    @GetMapping("/home")
    public ResponseEntity<String> sye(){
        return ResponseEntity.ok("hello from admin secured endpoint");
    }
}
