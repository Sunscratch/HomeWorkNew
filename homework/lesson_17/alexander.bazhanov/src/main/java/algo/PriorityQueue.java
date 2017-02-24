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
    if (size == array.length) {
      Object[] newArray = new Object[array.length * 2];
      System.arraycopy(array,0, newArray,0, array.length);
      array = newArray;
    }
    array[size] = item;
    swim(size);
    size++;
  }

  public T min() {
    return (T)array[0];
  }

  private void swim(int i) {
    while(!isRoot(i) && lessOrEqual(i, getParentIndex(i))){
      exchange(i, getParentIndex(i));
      i = getParentIndex(i);
    }
  }

  private void sink(int i){

  }
  @SuppressWarnings("unchecked")
  private boolean lessOrEqual(int child, int parent) {
    if (comparator == null) {
      return ((Comparable)array[child]).compareTo(array[parent]) < 1 ;
    } else {
      return (comparator.compare((T)array[child], (T)array[parent])) < 1;
    }

  }

  private boolean isRoot(int i) {
    return i == 0;
  }

  private int getParentIndex (int i) {
    return (i - 1) / 2;
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

  @SuppressWarnings("unchecked")
  private void exchange(int i, int k) {
    T temp = (T) array[i];
    array[i] = array[k];
    array[k] = temp;
  }

  public String testArray() {
    String result = "";
    for (int i = 0; i < size; i++) {
      result = result + array[i] + " ";
    }
    return result;
  }

}

