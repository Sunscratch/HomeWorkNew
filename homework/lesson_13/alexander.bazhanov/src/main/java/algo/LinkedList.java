package algo;

public class LinkedList<T> implements List<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  private static class Node<T>  {
    T value;
    Node<T> next;
    Node<T> previous;

    public Node(T value) {
      this.value = value;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void add(T item) {
    Node<T> current = new Node<T>(item);
    if (isEmpty()) {
      head = current;
    } else {
      tail.next = current;
      current.previous = tail;
    }
    tail = current;
    tail.next = null;
    size++;
  }

  public T get(int index) {
    if (index >= size) {
      System.out.println("Index out of bounds");
      return null;
    } else {
      Node<T> tmp = head;
      for (int i = 0; i < index && tmp.next != null; i++) {
        tmp = tmp.next;
      }
      return tmp.value;
    }
  }

  public void remove(int index) {
    Node<T> tmp = head;
    if (index == 0) {
      head = head.next;
      head.previous = null;
    } else {
      for (int i = 0; i < index && head.next != null; i++) {
        tmp = tmp.next;
      }
      tmp.previous.next = tmp.next;
      tmp.next = tmp.previous.previous;
    }
    size--;
  }

  public void clear() {
    head = tail = null;
    size = 0;
  }

  public Iterator<T> iterator() {
    return new ListIterator<T>(head);
  }

  public ReverseIterator<T> reverseIterator() {
    return new ReverseListIterator<T>(tail);
  }

  public class ListIterator<T> implements Iterator {
    Node<T> current;

    ListIterator(Node<T> node) {
      current = node;
    }

    public boolean hasNext() {
      return current != null;
    }

    public T next() {
      T item = current.value;
      current = current.next;
      return item;
    }
  }

  public class ReverseListIterator<T> implements ReverseIterator {
    Node<T> current;

    ReverseListIterator(Node<T> node) {
      current = node;
    }

    public boolean hasPrevious() {
      return current != null;
    }

    public T previous() {
      T item = current.value;
      current = current.previous;
      return item;
    }
  }
}
