package ru.counterpart.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI dictionaryApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Counterpart API")
                        .description("API сервиса Counterpart")
                        .version("v1.0.0"));
    }
}
