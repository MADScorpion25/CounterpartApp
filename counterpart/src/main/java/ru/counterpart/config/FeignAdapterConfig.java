package ru.counterpart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.counterpart.service.FileserviceAdapterService;
import ru.counterpart.service.ReportAdapterService;

@Configuration
public class FeignAdapterConfig {


    @Bean
    public ReportAdapterService reportAdapterService() {
        ReportAdapterService reportAdapterService = new ReportAdapterService();
        reportAdapterService.setUrl("http://localhost:8084/counterparts");
        return reportAdapterService;
    }

    @Bean
    public FileserviceAdapterService fileserviceAdapterService(ReportAdapterService reportAdapterService) {
        FileserviceAdapterService fileserviceAdapterService = new FileserviceAdapterService(reportAdapterService);
        fileserviceAdapterService.setUrl("http://localhost:8087/upload");
        return fileserviceAdapterService;
    }
}
