package com.example.oauth2_spring_project;

import com.example.oauth2_spring_project.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class OAuth2SpringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2SpringProjectApplication.class, args);
    }

}
