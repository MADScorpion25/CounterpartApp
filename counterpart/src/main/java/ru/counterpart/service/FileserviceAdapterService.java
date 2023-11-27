package ru.counterpart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileserviceAdapterService extends AbstractFeignAdapter {
    private final ReportAdapterService reportAdapterService;

    public void uploadReport() {
        byte[] content = reportAdapterService.getReport();
        sendPostRequest(void.class, content);
    }
}
