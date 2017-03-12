package algo;



public class BSTMap<K extends Comparable, V> {

  private Node root;

  private class Node {
    K key;
    V value;
    Node left;
    Node right;

    private Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public void put(K key, V value) {
    root = put(root, key, value);

  }

  private Node put(Node node, K key, V value) {
    if (node == null) {
      return new Node(key, value);
    } else {
      if (compare(key, node.key) < 0 ) {
        node.left = put(node.left, key, value);
      } else if (compare(key, node.key) > 0) {
        node.right = put(node.right, key, value);
      } else {
        node.value = value;
      }
      return node;
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
      } else {
        return node.value;
      }
    }
  }

  public void delete(K key) {
    if (root == null) {
      System.out.println("No such element");

    } else if (root.key == key) {
      swapValues(getNodeToSwap(root), root);

    } else {
      delete(root, key);

    }
  }

  private void delete(Node parent, K key) {
    Node child;
    if (compare(key, parent.key) > 0 && parent.right != null) {
      child = parent.right;
      if (child.key != key) {
        delete(child, key);
      } else {
        if (isLeaf(child)) {
          parent.right = null;
        } else {
          swapValues(getNodeToSwap(child), child);
        }
      }
    } else if (compare(key, parent.key) < 0 && parent.left != null){
      child = parent.left;
      if (child.key != key) {
        delete(child, key);
      } else {
        if (isLeaf(child)) {
          parent.left = null;
        } else {
          swapValues(getNodeToSwap(child), child);
        }
      }
    } else {
      System.out.println("No such element");
    }
  }

  private int compare(K keyOne, K keyTwo) {
    return keyOne.compareTo(keyTwo);
  }

  private boolean isLeaf(Node node) {
    return node.left == null && node.right == null;
  }

  private Node getNodeToSwap(Node node) {
    Node parent = node;
    Node result;
    if (parent.right != null) {
      if (isLeaf(parent.right)) {
        result = parent.right;
        parent.right = null;
      } else {
        if (parent.right.left == null) {
          result = parent.right;
          result.right = parent.right.right;
        } else {
          result = findMinNode(parent.right);
        }
      }
    } else {
      result = parent.left;
      parent.left = result.left;
      parent.right = result.right;
    }
    return result;
  }

  private void swapValues(Node from, Node to) {
    to.key = from.key;
    to.value = from.value;

  }


  private Node findMinNode(Node node) {
    Node parent = node;
    Node child = parent.left;
    if (child.left == null) {
      parent.left = null;
      return child;
    } else {
      return findMinNode(child);
    }
  }
}
