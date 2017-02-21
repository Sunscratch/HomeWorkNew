package algo;

public abstract class BinarySearch {
  public final int perform(Object[] unsorted, Object toFind) {
    return binarySearch(sort(unsorted), toFind);
  }

  protected abstract Object[] sort(Object[] unsorted);

  private int binarySearch(Object[] sorted, Object toFind) {
    int min = 0;
    int max = sorted.length;
    while (min <= max) {
      int middle = (min + max) / 2;
      if (sorted[middle].equals(toFind)) {
        return middle;
      } else if (((Comparable)sorted[middle]).compareTo(toFind) > 0) {
        max = middle - 1;
      } else if (((Comparable)sorted[middle]).compareTo(toFind) < 0) {
        min = middle + 1;
      }
    }
    return -1;
  }
}
