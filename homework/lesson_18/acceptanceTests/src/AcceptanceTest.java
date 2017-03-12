import algo.BSTMap;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class AcceptanceTest {
  @Test
  public void BasedOnBSTMapTestingWithDelete() {
    BSTMap<Integer, String> map = new BSTMap<>();

    map.put(10, "10");
    map.put(5, "5");
    map.put(6, "6");
    map.put(3, "3");
    map.put(4, "4");
    map.put(1, "1");
    map.put(20, "20");
    map.put(15, "15");
    map.put(11, "11");
    map.put(17, "17");
    map.put(18, "18");
    map.put(30, "30");
    map.put(40, "40");

    map.delete(10);

    assertThat(map.get(10), is(nullValue()));
    assertThat(map.get(20), is("20"));
    assertThat(map.get(40), is("40"));
    assertThat(map.get(30), is("30"));
    assertThat(map.get(5), is("5"));
    assertThat(map.get(6), is("6"));
    assertThat(map.get(3), is("3"));
    assertThat(map.get(4), is("4"));
    assertThat(map.get(1), is("1"));
    assertThat(map.get(15), is("15"));
    assertThat(map.get(11), is("11"));
    assertThat(map.get(17), is("17"));
    assertThat(map.get(18), is("18"));

    map.delete(17);

    assertThat(map.get(10), is(nullValue()));
    assertThat(map.get(20), is("20"));
    assertThat(map.get(40), is("40"));
    assertThat(map.get(30), is("30"));
    assertThat(map.get(5), is("5"));
    assertThat(map.get(6), is("6"));
    assertThat(map.get(3), is("3"));
    assertThat(map.get(4), is("4"));
    assertThat(map.get(1), is("1"));
    assertThat(map.get(15), is("15"));
    assertThat(map.get(11), is("11"));
    assertThat(map.get(17), is(nullValue()));
    assertThat(map.get(18), is("18"));

    map.delete(5);
    map.delete(6);
    map.delete(3);
    map.delete(4);

    assertThat(map.get(10), is(nullValue()));
    assertThat(map.get(20), is("20"));
    assertThat(map.get(40), is("40"));
    assertThat(map.get(30), is("30"));
    assertThat(map.get(5), is(nullValue()));
    assertThat(map.get(6), is(nullValue()));
    assertThat(map.get(3), is(nullValue()));
    assertThat(map.get(4), is(nullValue()));
    assertThat(map.get(1), is("1"));
    assertThat(map.get(15), is("15"));
    assertThat(map.get(11), is("11"));
    assertThat(map.get(17), is(nullValue()));
    assertThat(map.get(18), is("18"));

    map.delete(1);
    map.delete(30);
    map.delete(40);
    map.delete(20);

    assertThat(map.get(10), is(nullValue()));
    assertThat(map.get(20), is(nullValue()));
    assertThat(map.get(40), is(nullValue()));
    assertThat(map.get(30), is(nullValue()));
    assertThat(map.get(5), is(nullValue()));
    assertThat(map.get(6), is(nullValue()));
    assertThat(map.get(3), is(nullValue()));
    assertThat(map.get(4), is(nullValue()));
    assertThat(map.get(1), is(nullValue()));
    assertThat(map.get(15), is("15"));
    assertThat(map.get(11), is("11"));
    assertThat(map.get(17), is(nullValue()));
    assertThat(map.get(18), is("18"));

  }
}
