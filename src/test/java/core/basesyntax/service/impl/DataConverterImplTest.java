package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DataConverterImplTest {

    @Test
    void convertToTransaction() {
        List<String> stringArrayList =
                new ArrayList<>();
        stringArrayList.add("type,fruit,quantity");
        stringArrayList.add("b,banana,20");
        stringArrayList.add("b,apple,100");
        stringArrayList.add("s,banana,100");
        stringArrayList.add("p,banana,13");
        stringArrayList.add("r,apple,10");
        stringArrayList.add("p,apple,20");
        stringArrayList.add("p,banana,5");
        stringArrayList.add("s,banana,50");
        DataConverterImpl dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactionList =
                dataConverter.convertToTransaction(stringArrayList);

        assertEquals(8, fruitTransactionList.size());

    }

    @Test
    void convertToTransactionEdge() {
        List<String> stringArrayList =
                new ArrayList<>();
        stringArrayList.add("type,fruit,quantity");
        stringArrayList.add("b,banana,0");
        stringArrayList.add("p,banana,0");
        DataConverterImpl dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactionList =
                dataConverter.convertToTransaction(stringArrayList);

        assertEquals(0, fruitTransactionList.get(0).getQuantity());
        assertEquals("banana", fruitTransactionList.get(0).getFruit());
    }
}
