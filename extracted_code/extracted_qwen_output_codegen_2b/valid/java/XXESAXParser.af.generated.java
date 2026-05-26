package com.example.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.example.service.Config.ConfigService;

@Configuration
@ImportResource(value = "classpath:/com/example/service/ConfigService.xml")
@SpringBootApplication
public class ConfigServiceApplication {

    @Bean
    public ConfigService configService() throws IOException {
        return new ConfigService();
    }

    @Bean
    public Supplier<Optional<Properties>> serviceProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("src/main/resources/service.properties")));
        return () -> Optional.of(properties);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }
}