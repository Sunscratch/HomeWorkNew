package algo.stack;

public class LinkedListStack<T> implements Stack<T> {

  //private Node<T> head;
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

  public void push(T item) {
    Node<T> current = new Node<>(item);
    if (!isEmpty()) {
      tail.next = current;
      current.previous = tail;
    }
    tail = current;
    tail.next = null;
    size++;
  }

  public T pop() {
    if (size != 0) {
      T tmp = tail.value;
      removeFromStack();
      return tmp;
    } else {
      return null;
    }
  }

  private void removeFromStack() {
    if (size == 1) {
      tail = null;
    } else {
      tail = tail.previous;
      tail.next = null;
    }
    size--;
  }

  private boolean isEmpty() {
    return size == 0;
  }
}
