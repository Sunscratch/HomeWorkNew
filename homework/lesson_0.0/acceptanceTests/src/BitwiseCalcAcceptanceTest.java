import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BitwiseCalcAcceptanceTest {
  @Test
  public void simpleAndTesting() throws Exception {
    String left =  "0101";
    String right = "0011";

    assertThat(BitwiseCalc.and(left, right), is("0001"));
  }

  @Test
  public void simpleOrTesting() throws Exception {
    String left =  "0101";
    String right = "0011";

    assertThat(BitwiseCalc.or(left, right), is("0111"));
  }

  @Test
  public void simpleXorTesting() throws Exception {
    String left =  "0101";
    String right = "0011";

    assertThat(BitwiseCalc.xor(left, right), is("0110"));
  }

  @Test
  public void simpleNotTesting() throws Exception {
    assertThat(BitwiseCalc.not("0101"), is("1010"));
  }
}
