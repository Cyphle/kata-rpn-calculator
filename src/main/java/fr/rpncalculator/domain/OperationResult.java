package fr.rpncalculator.domain;

public class OperationResult {
  private int result;

  public OperationResult(int initialValue) {
    this.result = initialValue;
  }

  public int getResult() {
    return result;
  }

  public void accumulate(OperationResult resultToAccumulate) {
    this.result += resultToAccumulate.result;
  }
}
