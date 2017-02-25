package algo;

import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<T extends Comparable> implements Iterable<T> {

  private Object[] array = new Object[10];
  private int size = 0;
  private Comparator<T> comparator;

  public PriorityQueue(){}

  public PriorityQueue(Comparator comparator) {
    this.comparator = comparator;
  }

  public void insert(T item) {
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
    final T min = (T) array[0];
    array[0] = array[size - 1];
    array[size - 1] = null;
    size--;
    sink(0);
    return min;
  }

  private void swim(int index) {
    while (!isRoot(index) && lessOrEqual(index, getParentIndex(index))) {
      exchange(index, getParentIndex(index));
      index = getParentIndex(index);
    }
  }

  private void sink(int index) {

    while (getChildIndex(index) < size && lessOrEqual(getChildIndex(index), index)) {
      int child = getChildIndex(index);
      exchange(child, index);
      index = child;
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

  private boolean isRoot(int index) {
    return index == 0;
  }

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private int getLeftChildIndex(int index) {
    return 2 * index + 1;
  }

  private int getRightChildIndex(int index) {
    return 2 * index + 2;
  }

  private int getChildIndex(int index) {
    int leftChild = getLeftChildIndex(index);
    if (leftChild < size - 1 && lessOrEqual(getRightChildIndex(index), leftChild)) {
      return getRightChildIndex(index);
    }
    return leftChild;
  }

  @SuppressWarnings("unchecked")
  private void exchange(int firstElement, int secondElement) {
    T temp = (T) array[firstElement];
    array[firstElement] = array[secondElement];
    array[secondElement] = temp;
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

