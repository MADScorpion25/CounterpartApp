package ru.file.fileservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.file.fileservice.service.MinioAdapter;

@RestController
@RequiredArgsConstructor
public class FileController {
    private final MinioAdapter minioAdapter;

    @PostMapping("/upload")
    public void uploadFile(@RequestBody byte[] content) {
        minioAdapter.uploadFile("test.csv", content);
    }
}
