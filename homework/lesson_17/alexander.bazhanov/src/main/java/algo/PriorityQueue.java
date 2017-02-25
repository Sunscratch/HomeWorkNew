package algo;

import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<T extends Comparable> implements Iterable<T> {

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
    T min = (T) array[0];
    array[0] = array[size-1];
    array[size-1] = null;
    size--;
    sink(0);
    return min;
  }

  private void swim(int i) {
    while(!isRoot(i) && lessOrEqual(i, getParentIndex(i))){
      exchange(i, getParentIndex(i));
      i = getParentIndex(i);
    }
  }

  private void sink(int i) {

    while (getChildIndex(i) < size && lessOrEqual(getChildIndex(i), i)) {
      int child = getChildIndex(i);
      exchange(child, i);
      i = child;
    }

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
    int leftChild = getLeftChildIndex(i);
    if (leftChild < size - 1 && lessOrEqual(getRightChildIndex(i), leftChild)) {
      return getRightChildIndex(i);
    }
    return leftChild;
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


  @Override
  public Iterator<T> iterator() {
    return new PriorityQueueIterator(array);
  }

  private class PriorityQueueIterator implements Iterator<T> {
    private Object[] array;
    int index = 0;

    PriorityQueueIterator(Object[] array) {
      this.array = array;
    }

    public boolean hasNext() {
      return index < array.length && array[index] != null;
  }

    @Override
    public T next() {
      return (T) array[index++];
    }
  }

}

