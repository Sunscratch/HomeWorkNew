package algo;

public class BSTMap<K extends Comparable, V> {

  private Node root;

  private class Node {
    K key;
    V value;
    Node left;
    Node right;

    private Node (K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public void put(K key, V value){
    root = put(root, key, value);

  }

  private Node put(Node node, K key, V value) {
    if (node == null) {
      return new Node(key, value);
    } else {
      if (compare(key, node.key) < 0 ) {
        node.left = put(node.left, key, value);
      } else if (compare(key, node.key) > 0){
        node.right = put(node.right, key, value);
      } else {
        node.value = value;
      } return node;
    }
  }

  public V get(K key) {
    return get(root, key);
  }

  private V get(Node node, K key) {
    if (node == null) {
      return null;
    } else {
      if (compare(key, node.key) < 0) {
        return get(node.left, key);
      } else if (compare(key, node.key) > 0) {
        return get(node.right, key);
      } else return node.value;
    }
  }

  public void delete(K key) {
    delete(root, key);
  }

  private void delete(Node node, K key) {
    if (node == null) {
      System.out.println("No such element");
    } else {
      if (compare(key, node.key) < 0 ) {
        delete(node.left, key);
      } else if (compare(key, node.key) > 0){
        delete(node.right, key);
      } else {
        if (isLeaf(node)) {
          node = null;
        } else if (node.left != null && node.right != null) {
          node = null;
        } else{
          if (node.left != null) {
            node = node.left;
          } else node = node.right;
         }
      }
    }
  }

  private int compare(K keyOne, K keyTwo) {
    return keyOne.compareTo(keyTwo);
  }

  private boolean isLeaf(Node node) {
    return node.left == null && node.right == null;
  }

}
