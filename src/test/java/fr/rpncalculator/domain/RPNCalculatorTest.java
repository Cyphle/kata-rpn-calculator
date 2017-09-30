package fr.rpncalculator.domain;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
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
    assertThat(calculator.calculate("4 2 x")).isEqualTo(new Number(8));
  }

  private Object[] parametersForShould_calculate_rpn_operation() {
    return new Object[][]{
            {"3 5 8 x 7 + x", new Number(141)},
            {"3 4 2 1 + x + 2 /", new Number(7.5)},
            {"1 2 + 4 x 5 + 3 -", new Number(14)},
            {"5 4 1 2 + x +", new Number(17)}
    };
  }

  @Test
  @Parameters
  public void should_calculate_rpn_operation(final String operation, final Number result) throws Exception {
    assertThat(calculator.calculate(operation)).isEqualTo(result);
  }
}
