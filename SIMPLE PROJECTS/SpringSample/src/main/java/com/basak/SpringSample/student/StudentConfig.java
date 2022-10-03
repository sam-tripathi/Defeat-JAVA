package com.basak.SpringSample.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student A = new Student(
                    "Sample Name",
                    LocalDate.of(2000, Month.JANUARY, 20),
                    "example@email.com"
            );

            studentRepository.save(A);
        };
    }
}
