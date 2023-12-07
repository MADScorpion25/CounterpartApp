package ru.report.report.service;

import com.opencsv.CSVWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.report.report.domain.external.CounterpartCountState;
import ru.report.report.exception.ReportCreateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvExportService {

    private final CounterpartService counterpartService;

    public byte[] writeEmployeesToCsv() {
        List<CounterpartCountState> counterparts = counterpartService.findAllCounterparts();
        File file = new File("test.csv");
        try (FileWriter outputFile = new FileWriter(file)) {
            CSVWriter writer = new CSVWriter(outputFile);

            writer.writeNext(new String[]{"Статус", "Кол-во договоров"});
            counterparts.forEach(counterpart ->
                    writer.writeNext(new String[]{counterpart.getStatus().toString(), counterpart.getCount().toString()}));

            writer.close();
            file.createNewFile();
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            throw new ReportCreateException("Ошибка при формировании отчета");
        }
    }
}
