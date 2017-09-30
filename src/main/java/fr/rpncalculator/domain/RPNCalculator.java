package fr.rpncalculator.domain;

import java.util.Arrays;
import java.util.Stack;

public class RPNCalculator implements Calculator {
  private static final String SEPARATOR = " ";
  private final Stack<Number> operationMembers;

  RPNCalculator() {
    this.operationMembers = new Stack<>();
  }

  @Override
  public Number calculate(String operation) {
    for (String element : Arrays.asList(operation.split(SEPARATOR))) {
      evaluateElement(element);
    }
    return operationMembers.pop();
  }

  private void evaluateElement(String element) {
    operationMembers.push(
            Number.Operation
                    .findByOperator(element)
                    .map(this::applyOperation)
                    .orElseGet(() -> new Number(element))
    );
  }

  private Number applyOperation(Number.Operation operation) {
    Number secondMember = operationMembers.pop();
    Number firstMember = operationMembers.pop();
    return operation.calculate(firstMember, secondMember);
  }
}
