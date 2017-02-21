package algo.queue;

public class LinkedListQueue<T> implements Queue<T> {

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

  public void enqueue(T item) {
    Node<T> current = new Node<>(item);
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

  public T dequeue() {
    if (size != 0) {
      T tmp = head.value;
      removeFromQueue();
      return tmp;
    } else {
      return null;
    }
  }

  private void removeFromQueue() {
    if (size == 1) {
      head = null;
    } else {
      head = head.next;
      head.previous = null;
    }
    size--;
  }

  private boolean isEmpty() {
    return size == 0;
  }

}
