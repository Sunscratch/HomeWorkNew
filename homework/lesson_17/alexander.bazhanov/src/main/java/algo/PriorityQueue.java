package algo;


public class PriorityQueue<T extends Comparable> {

  Node root;

  public void insert (T item) {
    Node newNode = new Node(item);
    Node current = root;
    if (root == null) root = newNode;
    else {
      if (newNode.data.compareTo(current.data) > 0 && hasNoBranches(current)) {
        current.left = newNode;
      }
      //else if ()
    }
  }

  public T min() {
    return root.data;
  }

  private class Node {
    Node left;
    Node right;
    T data;

    Node(T item) {
      data = item;
    }

  }
  private boolean hasNoBranches(Node node) {
    return node.left == null && node.right == null;
  }

}
