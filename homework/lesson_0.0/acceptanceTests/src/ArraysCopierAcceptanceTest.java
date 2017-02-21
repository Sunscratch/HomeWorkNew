import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class ArraysCopierAcceptanceTest {
  private ArraysCopier copier;

  @Before
  public void setUp() {
    copier = new ArraysCopier(new int[] {1, 2, 3, 4, 5});
  }

  @Test
  public void copyOfTheSameLengthArray() throws Exception {
    assertThat_CopyOf(5, new int[] {1, 2, 3, 4, 5});
  }

  @Test
  public void copyOfEmptyArray() throws Exception {
    assertThat_CopyOf(0, new int[] {});
  }

  @Test
  public void copyOfBiggerArray() throws Exception {
    assertThat_CopyOf(10, new int[] {1, 2, 3, 4, 5, 0, 0, 0, 0, 0});
  }

  @Test
  public void copyOfSmallerArray() throws Exception {
    assertThat_CopyOf(2, new int[] {1, 2});
  }

  private void assertThat_CopyOf(int newLength, int[] equalsToArray) {
    assertThat(Arrays.equals(copier.copyOf(newLength), equalsToArray), is(true));
  }

  @Test
  public void coppyFirstHalfOfArray() throws Exception {
    assertThat_CopyOfRange(0, 2, new int[] {1, 2});
  }

  @Test
  public void coppySecondHalfOfArray() throws Exception {
    assertThat_CopyOfRange(2, 4, new int[] {3, 4});
  }

  @Test
  public void coppyOneElementOfArray_shouldReturnEmptyArray() throws Exception {
    assertThat_CopyOfRange(4, 4, new int[] {});
  }

  @Test
  public void coppyWrongRangeOfArray() throws Exception {
    assertThat(copier.copyOfRange(4, 2), is(nullValue()));
  }

  private void assertThat_CopyOfRange(int from, int to, int[] equalsToArray) {
    assertThat(Arrays.equals(copier.copyOfRange(from, to), equalsToArray), is(true));
  }

  @Test
  public void fillWithZeroValue() {
    assertThat_fillWithValue(0, new int[] {0, 0, 0, 0, 0});
  }

  @Test
  public void fillWithNegativeValue() {
    assertThat_fillWithValue(-1, new int[] {-1, -1, -1, -1, -1});
  }

  private void assertThat_fillWithValue(int value, int[] equalsToArray) {
    assertThat(Arrays.equals(copier.fill(value), equalsToArray), is(true));
  }
}
