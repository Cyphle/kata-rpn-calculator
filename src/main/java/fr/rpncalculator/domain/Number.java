package fr.rpncalculator.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Number {
  private BigDecimal value;

  Number(double value) {
    this.value = new BigDecimal(value, MathContext.DECIMAL64);
  }

  Number(String value) {
    this.value = new BigDecimal(Double.valueOf(value), MathContext.DECIMAL64);
  }

  private Number(BigDecimal value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Number number = (Number) o;

    return value != null ? value.equals(number.value) : number.value == null;
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Number{" +
            "value=" + value +
            '}';
  }

  enum Operation {
    PLUS("+", (a, b) -> new Number(a.value.add(b.value))),
    MINUS("-", (a, b) -> new Number(a.value.subtract(b.value))),
    DIVIDE("/", (a, b) -> new Number(a.value.divide(b.value, BigDecimal.ROUND_FLOOR))),
    MULTIPLY("*", (a, b) -> new Number(a.value.multiply(b.value)));

    final String operator;
    final BinaryOperator<Number> operation;

    Operation(String operator, BinaryOperator<Number> operation) {
      this.operator = operator;
      this.operation = operation;
    }

    public Number calculate(Number firstMember, Number secondMember) {
      return operation.apply(firstMember, secondMember);
    }

    public static Optional<Operation> findByOperator(String operator) {
      return Arrays.stream(Operation.values()).filter(operand -> operand.operator.equals(operator)).findAny();
    }
  }
}
