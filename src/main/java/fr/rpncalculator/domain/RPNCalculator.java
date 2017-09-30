package fr.rpncalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RPNCalculator implements Calculator {
  @Override
  public int calculate(String operation) {
    Stack<String> operationElements = new Stack<>();
    operationElements.addAll(Arrays.asList(operation.split(" ")));

    if (operationElements.size() > 1) {
      OperationResult result = new OperationResult(0);
      return parseOperation(result, operationElements).getResult();
    }
    return Integer.valueOf(operation);
  }

  private OperationResult parseOperation(OperationResult result, List<String> operationElements) {
    Operand.findByOperator(operationElements.get(2))
            .ifPresent(operand -> result.accumulate(
                    new OperationResult(
                            operand.calculate(
                                    Integer.valueOf(operationElements.get(0)),
                                    Integer.valueOf(operationElements.get(1))
                            )
                    )
            ));
    return result;
  }
}
