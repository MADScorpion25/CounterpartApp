package com.gateway.gateway.config;

import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class RouteConfig {

    @NotBlank
    @Value("${routing.counterpart-url}")
    private String counterpartUrl;

    @NotBlank
    @Value("${routing.report-url}")
    private String reportUrl;

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("counterpart",
                        route -> route.path("/api/**")
                                .filters(filter -> filter.stripPrefix(1))
                                .uri(counterpartUrl))
                .route("reports",
                        route -> route.path("/rep/**")
                                .filters(filter -> filter.stripPrefix(1))
                                .uri(reportUrl))
                .build();
    }
}
