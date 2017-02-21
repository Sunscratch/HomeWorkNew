package algo;

import java.util.Random;

public class ArrayList<T> implements List<T> {

  private Object[] array = new Object[10];
  int size;

  public void add(T item) {
    if (size == array.length) {
      Object[] newArray = new Object[(array.length * 3) / 2 + 1];
      System.arraycopy(array,0,newArray,0,array.length);
      array = newArray;
    }
    for (int i = 0; i < array.length; i++) {
      if (array[i] == null) {
        array[i] = item;
        break;
      }
    }
    size++;
  }

  public T get(int index) {
    return (T) array[index];
  }

  public void remove(int index) {
    for (int i = index; i < array.length - 1; i++) {
      array[i] = array[i + 1];
    }
    array[--size] = null;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void clear() {
    for (int i = 0; i < size; i++) {
      array[i] = null;
    }
    size = 0;
  }

  public Iterator<T> iterator() {
    return new ArrayListIterator(0);
  }

  private class ArrayListIterator implements Iterator {
    int index;

    public ArrayListIterator(int index) {
      this.index = index;
    }

    public boolean hasNext() {
      return index < size;
    }

    public T next() {
      return (T)array[index++];
    }
  }

  public ReverseIterator<T> reverseIterator() {
    return new ArrayListReverseIterator(size - 1);
  }

  private class ArrayListReverseIterator implements ReverseIterator {
    int index;

    public ArrayListReverseIterator(int index) {
      this.index = index;
    }

    public boolean hasPrevious() {
      return index >= 0;
    }

    public T previous() {
      return (T)array[index--];
    }
  }

  public Iterator<T> randomIterator() {
    Random random = new Random();
    return new ArrayListIterator(random.nextInt(size));
  }
}
