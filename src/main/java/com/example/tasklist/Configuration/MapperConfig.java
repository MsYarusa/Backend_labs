package com.example.tasklist.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    // объявляем маппер, который значительно облегчает преобразование модели в DTO
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
