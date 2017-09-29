package fr.rpncalculator.domain;

public class RPNCalculator implements Calculator {
  @Override
  public int calculate(String operation) {
    return Integer.valueOf(operation);
  }
}
