package fr.rpncalculator.domain;

import java.util.Arrays;
import java.util.List;

public class RPNCalculator implements Calculator {
  @Override
  public int calculate(String operation) {
    List<String> operationElements = Arrays.asList(operation.split(" "));
    if (operationElements.size() > 1)
      return Integer.valueOf(operationElements.get(0)) + Integer.valueOf(operationElements.get(1));
    return Integer.valueOf(operation);
  }
}
