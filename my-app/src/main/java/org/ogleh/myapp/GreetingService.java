package org.ogleh.myapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class GreetingService {
    private final GreetingRepository greetingRepository;


    public void greet(Greeting greeting) {
        greetingRepository.save(greeting);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
