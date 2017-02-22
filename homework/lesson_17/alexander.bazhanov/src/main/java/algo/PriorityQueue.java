package algo;


import java.util.Comparator;

public class PriorityQueue<T extends Comparable> {

  private Object[] array = new Object[10];
  private int size = 0;
  private Comparator<T> comparator;

  public PriorityQueue(){}

  public PriorityQueue(Comparator comparator){
    this.comparator = comparator;
  }

  public void insert (T item) {

  }

  public T min() {
    return (T)array[0];
  }

  private void swim(int i) {

  }

  private void sink(int i){

  }

  private boolean lessOrEqual(int first, int second) {
    if (comparator == null) {
      return ((Comparable)array[first]).compareTo(array[second]) < 1;
    } else {
      return (comparator.compare((T)array[first], (T)array[second])) < 1;
    }

  }

  private boolean isRoot(int i) {
    return i == 0;
  }

  private int getLeftChildIndex(int i) {
    return 2 * i + 1;
  }

  private int getRightChildIndex(int i) {
    return 2 * i + 2;
  }

  private int getChildIndex(int i) {
    if (size % 2 == 0) {
      return getRightChildIndex(i);
    }
    return getLeftChildIndex(i);
  }

}
