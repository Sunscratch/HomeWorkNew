package algo;

import java.util.Comparator;

public class PQSorter {

  private Order order;

  public static enum Order {
    ASCENDING, DESCENDING,
  }

  public PQSorter(Order order) {
    this.order = order;
  }

  public <T extends Comparable> T[] sort(T[] unsorted) {
    PriorityQueue<T> pq = makeHeap(unsorted);
    for (int i = 0; pq.getSize() != 0; i++) {
      unsorted[i] = pq.min();
    }
    return unsorted;
  }

  private<T extends Comparable> PriorityQueue<T> makeHeap(T[] array) {
    PriorityQueue<T> pq = new PriorityQueue<>(new CustomComparator());
   for (T element:array) {
      pq.insert(element);
    }
    return pq;
  }

  private class CustomComparator<T extends Comparable> implements Comparator<T> {

    @Override
    public int compare(T firstElement, T secondElement) {
      if (order == order.ASCENDING) {
        return firstElement.compareTo(secondElement);
      } else
        return (firstElement.compareTo(secondElement) * -1);
    }
  }
}
