package org.ogleh.myapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class MyAppApplication {
    public final GreetingService greetingService;

    @GetMapping("")
    public String greet() {
        return "Asc World";
    }

    @GetMapping("/{name}")
    public String greet(@PathVariable String name) {
        return "Asc " + name;
    }

    @PostMapping("/create/greet")
    public String greet(@RequestBody Greeting greeting) {
        greetingService.greet(greeting);
        return "Asc we got your greetings";
    }
    @GetMapping("/all")
    public List<Greeting> greetings() {
        return greetingService.getAllGreetings();
    }


    public static void main(String[] args) {
        SpringApplication.run(MyAppApplication.class, args);
    }
}
