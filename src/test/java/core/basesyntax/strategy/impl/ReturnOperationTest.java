package core.basesyntax.strategy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.Test;

class ReturnOperationTest {

    @Test
    void operateValidData() {
        ReturnOperation returnOperation = new ReturnOperation();
        Storage storage = new Storage();
        storage.set("apple", 100);
        returnOperation.operate(new FruitTransaction("b", "apple", 100), storage);
        assertEquals(200, storage.getQuantityByFruit("apple"));
    }

    @Test
    void operateValidDataEdge() {
        ReturnOperation returnOperation = new ReturnOperation();
        Storage storage = new Storage();
        storage.set("apple", 0);
        returnOperation.operate(new FruitTransaction("b", "apple", 0), storage);
        assertEquals(0, storage.getQuantityByFruit("apple"));
    }
}

