package ru.counterpart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.counterpart.service.ReportAdapterService;

@Configuration
public class FeignAdapterConfig {

    @Bean
    public ReportAdapterService reportAdapterService() {
        ReportAdapterService reportAdapterService = new ReportAdapterService();
        reportAdapterService.setUrl("http://localhost:8084/counterparts");
        return reportAdapterService;
    }
}
