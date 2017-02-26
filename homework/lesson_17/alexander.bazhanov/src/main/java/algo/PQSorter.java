package algo;

import java.util.Comparator;

public class PQSorter implements Comparator {

  private Order order;

  @Override
  public int compare(Object o1, Object o2) {
    return 0;
  }

  public static enum Order {
    ASCENDING, DESCENDING,
  }

  public PQSorter(Order order) {
    this.order = order;
  }

  public <T> T[] sort(T[] unsorted) {
    return unsorted;
  }
}
