package core.basesyntax.strategy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.Test;

class BalanceOperationTest {

    @Test
    void operateValidData() {
        BalanceOperation balanceOperation = new BalanceOperation();
        Storage storage = new Storage();
        balanceOperation.operate(new FruitTransaction("b", "apple", 100), storage);
        assertEquals(100, storage.getQuantityByFruit("apple"));
    }

    @Test
    void operateValidDataEdge() {
        BalanceOperation balanceOperation = new BalanceOperation();
        Storage storage = new Storage();
        balanceOperation.operate(new FruitTransaction("b", "apple", 0), storage);
        assertEquals(0, storage.getQuantityByFruit("apple"));
    }
}
