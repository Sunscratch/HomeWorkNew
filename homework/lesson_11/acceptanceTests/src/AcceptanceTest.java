import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import calculator.SimpleStringCalculator;

public class AcceptanceTest {
  public SimpleStringCalculator calc1;

  @Before
  public void setUp() {
    calc1 = new SimpleStringCalculator();
  }

  @Test
  public void testingIfAddIsWorkingCorrect() {
    assertThat(calc1.add("#2,2,100+2#2"), is(108));
    assertThat(calc1.add("#2,2,10+2#200"), is(216));
  }

  @Test
  public void testingIfAddIgnoresThousands() {
    assertThat(calc1.add("#2,20000,1000+2#2"), is(6));
  }

  @Test
  public void testingWithNegativeNumberShouldReturnMinusOne() {
    assertThat(calc1.add("#2,-2,1001+2#2"), is(-1));
  }

  @Test
  public void testingVoidStringShouldReturnZero() {
    assertThat(calc1.add(""), is(0));
  }

  @Test
  public void testingShouldWorkWithDifferentDeviders() {
    assertThat(calc1.add("#/+2,+8,7.2;2"), is(21));
  }

}
