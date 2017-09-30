package fr.rpncalculator.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RPNCalculatorTest {
  private Calculator calculator;

  @Before
  public void setUp() throws Exception {
    calculator = new RPNCalculator();
  }

  @Test
  public void should_return_same_value_if_there_is_only_one() throws Exception {
    assertThat(calculator.calculate("3")).isEqualTo(new Number(3));
  }

  @Test
  public void should_calculate_8_when_adding_3_and_5() throws Exception {
    assertThat(calculator.calculate("3 5 +")).isEqualTo(new Number(8));
  }

  @Test
  public void should_calculate_3_when_dividing_6_by_2() throws Exception {
    assertThat(calculator.calculate("6 2 /")).isEqualTo(new Number(3));
  }

  @Test
  public void should_calculate_7_when_subtracting_3_to_10() throws Exception {
    assertThat(calculator.calculate("10 3 -")).isEqualTo(new Number(7));
  }

  @Test
  public void should_calculate_8_when_multiplying_4_by_2() throws Exception {
    assertThat(calculator.calculate("4 2 *")).isEqualTo(new Number(8));
  }
}
