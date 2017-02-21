package algo;

import algo.BinarySearch;

public class BubbleSortBinarySearch extends BinarySearch {

  public Object[] sort(Object[] unsorted) {
    Object tmp = new Object();
    for (int i = 0; i < unsorted.length; i++) {
      for (int j = 1; j < unsorted.length - 1; j++) {
        if (firstBiggerThanSecond(unsorted[j - 1],unsorted[j])) {
          tmp = unsorted[j];
          unsorted[j] = unsorted[j - 1];
          unsorted[j - 1] = tmp;
        }
      }
    }
    return unsorted;
  }

  private boolean firstBiggerThanSecond(Object first, Object second) {
    return ((Comparable)first).compareTo(second) > 0;
  }
}
