package fr.rpncalculator.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RPNCalculatorTest {
  @Test
  public void should_return_same_value_if_there_is_only_one() throws Exception {
    Calculator calculator = new RPNCalculator();
    assertThat(calculator.calculate("3")).isEqualTo(3);
  }
}
