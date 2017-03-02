package algo;

public class BSTMap<K extends Comparable, V> {

  Node root;

  private class Node {
    K key;
    V value;
    Node left;
    Node rigth;

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
        node.rigth = put(node.rigth, key, value);
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
        return get(node.rigth, key);
      } else return node.value;
    }
  }

  public void delete(K key) {

  }

  private int compare(K keyOne, K keyTwo) {
    return keyOne.compareTo(keyTwo);
  }

}
