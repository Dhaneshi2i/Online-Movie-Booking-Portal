package com.ideas2it.bookmymovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class BookMyMovieApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookMyMovieApplication.class, args);
    }

}

