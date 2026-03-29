package core.basesyntax.strategy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.Test;

class SupplyOperationTest {

    @Test
    void operateValidData() {
        SupplyOperation supplyOperation = new SupplyOperation();
        Storage storage = new Storage();
        storage.set("apple", 100);
        supplyOperation.operate(new FruitTransaction("b", "apple", 100), storage);
        assertEquals(200, storage.getQuantityByFruit("apple"));
    }

    @Test
    void operateValidDataEdge() {
        SupplyOperation supplyOperation = new SupplyOperation();
        Storage storage = new Storage();
        storage.set("apple", 0);
        supplyOperation.operate(new FruitTransaction("b", "apple", 0), storage);
        assertEquals(0, storage.getQuantityByFruit("apple"));
    }
}
