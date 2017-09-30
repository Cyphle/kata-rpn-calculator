package fr.rpncalculator.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

enum Operand {
  PLUS("+", (a, b) -> a + b ),
  MINUS("-", (a, b) -> a - b),
  DIVIDE("/", (a, b) -> a / b),
  MULTIPLY("*", (a, b) -> a * b);

  final String operator;
  final BinaryOperator<Integer> operation;

  Operand(String operator, BinaryOperator<Integer> operation) {
    this.operator = operator;
    this.operation = operation;
  }

  public int calculate(int first, int second) {
    return operation.apply(first, second);
  }

  public static Optional<Operand> findByOperator(String operator) {
    return Arrays.stream(Operand.values()).filter(operand -> operand.operator.equals(operator)).findAny();
  }
}
