package com.ideas2it.bookmymovie.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper ModelMapper() {
        ModelMapper modelMapper =  new ModelMapper();
        return modelMapper;
    }
}
