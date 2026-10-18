package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

// Tutorial 1
@RestController
public class HelloController {

    // Activity 1
    @GetMapping("/")
    public String home() {
        return "Welcome to Products API";
    }

    // Activity 2
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    // Activity 3
    @GetMapping("/status")
    public String status() {
        return "API running - " + LocalDate.now();
    }

    // Activity 4
    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye from Spring Boot!";
    }
}
