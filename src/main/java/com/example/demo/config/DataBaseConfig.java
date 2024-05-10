package com.example.demo.config;

import com.example.demo.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {
    @Bean
    public UserRepository UserRepository() {
        return new UserRepository(); //userRepository 빈으로 등록
    }
}
