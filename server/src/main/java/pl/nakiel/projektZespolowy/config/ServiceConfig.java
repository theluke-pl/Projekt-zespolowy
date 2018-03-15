package pl.nakiel.projektZespolowy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "pl.nakiel.projektZespolowy.service" })
public class ServiceConfig {
}
