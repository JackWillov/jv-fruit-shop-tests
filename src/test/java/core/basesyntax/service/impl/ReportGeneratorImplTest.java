package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.Test;

class ReportGeneratorImplTest {

    @Test
    void getReportEmptyStorage() {
        String expected = "fruit,quantity\n";
        Storage storage = new Storage();
        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl(storage);

        assertEquals(expected, reportGenerator.getReport());
    }

    @Test
    void convertToCsvEmptyStorageReturnOnlyHeader() {
        String expected = "fruit,quantity\n";
        Storage storage = new Storage();
        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl(storage);

        assertEquals(expected, reportGenerator.convertToCsv(storage));
    }

    @Test
    void convertToCsvValidDate() {
        String expected = "fruit,quantity\napple,100\n";
        Storage storage = new Storage();
        storage.set("apple", 100);
        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl(storage);

        assertEquals(expected, reportGenerator.convertToCsv(storage));
    }
}
