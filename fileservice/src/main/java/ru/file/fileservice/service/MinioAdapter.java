package ru.file.fileservice.service;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.messages.Bucket;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class MinioAdapter {
    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucket.name}")
    private String defaultBucketName;

    @Value("${minio.default.folder}")
    private String defaultBaseFolder;

    public List<Bucket> getAllBuckets() {
        try {
            return minioClient.listBuckets();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }


    public void uploadFile(String name, byte[] content) {
        File file = new File(name);
        try (FileOutputStream output = new FileOutputStream(file); InputStream iofs = new FileInputStream(file)) {
            output.write(content);
            file.createNewFile();
            file.canWrite();
            file.canRead();
            PutObjectArgs build = PutObjectArgs.builder()
                    .stream(iofs, -1, 45000000)
                    .contentType("text/csv")
                    .bucket(defaultBucketName)
                    .object(file.getName())
                    .build();
            minioClient.putObject(build);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

//    public byte[] getFile(String key) {
//        try {
//            InputStream obj = minioClient.getObject(defaultBucketName, defaultBaseFolder + "/" + key);
//
//            byte[] content = obj.readAllBytes();
//            obj.close();
//            return content;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @PostConstruct
    public void init() {
    }
}
