package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Tutorial 1
@RestController
public class InfoController {

    // Activity 5
    @GetMapping("/info")
    public String info() {
        return "Hello, this is my products API.";
    }
}


