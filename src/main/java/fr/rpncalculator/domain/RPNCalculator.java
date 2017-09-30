package fr.rpncalculator.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class RPNCalculator implements Calculator {
  private static final String SEPARATOR = " ";
  private final Stack<Number> operationMembers;

  public RPNCalculator() {
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
    Optional<Number.Operation> operation = Number.Operation.findByOperator(element);

    if (operation.isPresent()) {
      Number secondMember = operationMembers.pop();
      Number firstMember = operationMembers.pop();
      operationMembers.push(operation.get().calculate(firstMember, secondMember));
    } else {
      operationMembers.push(new Number(element));
    }
  }
}
