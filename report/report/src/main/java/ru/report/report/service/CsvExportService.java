package ru.report.report.service;

import com.opencsv.CSVWriter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import ru.report.report.domain.external.Counterpart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvExportService {

    private final CounterpartService counterpartService;

    public byte[] writeEmployeesToCsv() {
        List<Counterpart> counterparts = counterpartService.findAllCounterparts();
        File file = new File("test.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            writer.writeNext(new String[]{"ContractNumber", "ContractStatus", "Manager", "PartnerName"});
            counterparts.forEach(counterpart ->
                    writer.writeNext(new String[]{counterpart.getContractNumber().toString(),
                            counterpart.getContractStatus().toString(), counterpart.getManager(), counterpart.getPartnerName()}));

            // closing writer connection
            writer.close();
            file.createNewFile();
            return Files.readAllBytes(file.toPath());
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
