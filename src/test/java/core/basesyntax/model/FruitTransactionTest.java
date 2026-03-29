package core.basesyntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FruitTransactionTest {
    private final String expectedFruit = "apple";
    private final String expectedOperation = "b";
    private final int expectedQuantity = 12;

    private final FruitTransaction fruitTransaction =
            new FruitTransaction(expectedOperation, expectedFruit, expectedQuantity);

    @Test
    void getFruitValidData() {
        assertEquals(expectedFruit, fruitTransaction.getFruit());
    }

    @Test
    void getQuantityValidData() {
        assertEquals(expectedQuantity, fruitTransaction.getQuantity());
    }

    @Test
    void getOperationValidData() {
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.fromCode(expectedOperation);
        assertEquals(operation, fruitTransaction.getOperation());
    }
}
