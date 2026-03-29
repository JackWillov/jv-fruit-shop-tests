package core.basesyntax.strategy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class OperationStrategyImplTest {
    static final Map<FruitTransaction.Operation, OperationHandler> operationHandlers =
            new HashMap<>();

    @Test
    void get() {
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlers);
        FruitTransaction fruitTransaction = new FruitTransaction("b", "apple", 100);
        OperationHandler actualHandler = operationStrategy.get(fruitTransaction.getOperation());

        assertEquals(BalanceOperation.class, actualHandler.getClass());
    }
}
