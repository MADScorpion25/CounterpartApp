package ru.counterpart;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CounterpartApplication {

    public static void main(String[] args) {
        SpringApplication.run(CounterpartApplication.class, args);
    }
}
