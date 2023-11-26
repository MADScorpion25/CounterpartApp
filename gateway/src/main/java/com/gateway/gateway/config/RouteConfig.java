package com.gateway.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class RouteConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("counterpart",
                        route -> route.path("/api/**")
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("http://localhost:8080/"))
                .route("reports",
                        route -> route.path("/rep/**")
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("http://localhost:8084/"))
                .build();
    }
}
