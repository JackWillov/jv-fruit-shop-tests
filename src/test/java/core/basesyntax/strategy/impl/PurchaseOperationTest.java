package core.basesyntax.strategy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.Test;

class PurchaseOperationTest {

    @Test
    void operateNotEnoughFruitsThrowRuntimeException() {
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        Storage storage = new Storage();
        storage.set("apple", 20);
        assertThrows(RuntimeException.class, () -> {
            purchaseOperation.operate(
                    new FruitTransaction("p", "apple", 100),
                    storage
            );
        });

    }

    @Test
    void operateValidData() {
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        Storage storage = new Storage();
        storage.set("apple", 120);
        purchaseOperation.operate(new FruitTransaction("p", "apple", 100), storage);

        assertEquals(20, storage.getQuantityByFruit("apple"));
    }
}
