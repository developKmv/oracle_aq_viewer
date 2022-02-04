package ru.mvxdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.mvxdev.objects.ConnectionORA;

import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "ru.mvxdev")
public class AppConfig {

}
