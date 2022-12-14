package com.ideas2it.bookmymovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableCaching
public class BookMyMovieApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookMyMovieApplication.class, args);
    }

}

