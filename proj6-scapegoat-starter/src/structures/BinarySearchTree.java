package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T> {
  protected BSTNode<T> root;

  public boolean isEmpty() {
    return root == null;
  }

  public int size() {
    return subtreeSize(root);
  }

  protected int subtreeSize(BSTNode<T> node) {
    if (node == null) {
      return 0;
    } else {
      return 1 + subtreeSize(node.getLeft()) + subtreeSize(node.getRight());
    }
  }

  public boolean contains(T t) throws NullPointerException {
    if (t == null) {
      throw new NullPointerException("Cannot search for a nonexistant node");
    }
    BSTNode<T> rootNode = root;
    boolean containsSearch = false;

    if (rootNode != null) {
      if (rootNode.getData().compareTo(t) == 0) {
        containsSearch = true;
      } else if (rootNode.getData().compareTo(t) > 0) {
        if (rootNode.getLeft() != null) {
          containsSearch = containsRecursive(t, rootNode.getLeft());
        }
      } else {
        if (rootNode.getRight() != null) {
          containsSearch = containsRecursive(t, rootNode.getRight());
        }
      }
    }

    return containsSearch;
  }

  private boolean containsRecursive(T t, BSTNode<T> currentNode) {
    boolean found = false;

    if (currentNode.getData().compareTo(t) == 0) {
      found = true;
    } else if (currentNode.getData().compareTo(t) > 0) {
      if (currentNode.getLeft() != null) {
        found = containsRecursive(t, currentNode.getLeft());
      }
    } else {
      if (currentNode.getRight() != null) {
        found = containsRecursive(t, currentNode.getRight());
      }
    }

    return found;
  }

  public boolean remove(T t) {
    if (t == null) {
      throw new NullPointerException();
    }
    boolean result = contains(t);
    if (result) {
      root = removeFromSubtree(root, t);
    }
    return result;
  }

  private BSTNode<T> removeFromSubtree(BSTNode<T> node, T t) {
    // node must not be null
    int result = t.compareTo(node.getData());
    if (result < 0) {
      node.setLeft(removeFromSubtree(node.getLeft(), t));
      return node;
    } else if (result > 0) {
      node.setRight(removeFromSubtree(node.getRight(), t));
      return node;
    } else { // result == 0
      if (node.getLeft() == null) {
        return node.getRight();
      } else if (node.getRight() == null) {
        return node.getLeft();
      } else { // neither child is null
        T predecessorValue = getHighestValue(node.getLeft());
        node.setLeft(removeRightmost(node.getLeft()));
        node.setData(predecessorValue);
        return node;
      }
    }
  }

  private T getHighestValue(BSTNode<T> node) {
    // node must not be null
    if (node.getRight() == null) {
      return node.getData();
    } else {
      return getHighestValue(node.getRight());
    }
  }

  private BSTNode<T> removeRightmost(BSTNode<T> node) {
    // node must not be null
    if (node.getRight() == null) {
      return node.getLeft();
    } else {
      node.setRight(removeRightmost(node.getRight()));
      return node;
    }
  }

  public T get(T t) throws NullPointerException {
    if (t == null) {
      throw new NullPointerException("Cannot search for a null item.");
    }
    BSTNode<T> rootNode = root;
    T data = null;

    if (rootNode != null) {
      int comparedValue = rootNode.getData().compareTo(t);

      if (comparedValue == 0) {
        data = rootNode.getData();
      } else if (comparedValue > 0 && rootNode.getLeft() != null) {
        data = getFromSubtree(t, rootNode.getLeft());
      } else if (rootNode.getRight() != null) {
        data = getFromSubtree(t, rootNode.getRight());
      }

    }

    return data;
  }

  private T getFromSubtree(T t, BSTNode<T> node) {
    T data = null;

    int comparedValue = node.getData().compareTo(t);
    if (comparedValue == 0) {
      data = node.getData();
    } else if (comparedValue > 0 && node.getLeft() != null) {
      data = getFromSubtree(t, node.getLeft());
    } else {
      if (node.getRight() != null) {
        data = getFromSubtree(t, node.getRight());
      }
    }

    return data;
  }

  public void add(T t) {
    if (t == null) {
      throw new NullPointerException();
    }
    root = addToSubtree(root, new BSTNode<T>(t, null, null));
  }

  protected BSTNode<T> addToSubtree(BSTNode<T> node, BSTNode<T> toAdd) {
    if (node == null) {
      return toAdd;
    }
    int result = toAdd.getData().compareTo(node.getData());
    if (result <= 0) {
      node.setLeft(addToSubtree(node.getLeft(), toAdd));
    } else {
      node.setRight(addToSubtree(node.getRight(), toAdd));
    }
    return node;
  }

  @Override
  public T getMinimum() {
    T data = null;
    BSTNode<T> currentNode = (root != null) ? root : null;

    if (currentNode != null) {
      while (currentNode.getLeft() != null) {
        currentNode = currentNode.getLeft();
      }
      data = currentNode.getData();
    }

    return data;
  }

  @Override
  public T getMaximum() {
    T data = null;
    BSTNode<T> currentNode = (root != null) ? root : null;

    if (currentNode != null) {
      while (currentNode.getRight() != null) {
        currentNode = currentNode.getRight();
      }
      data = currentNode.getData();
    }

    return data;
  }

  @Override
  public int height() {
    // TODO: Implement the height() method
    return -2;
  }

  public Iterator<T> preorderIterator() {
    // TODO: Implement the preorderIterator() method
    return null;
  }

  public Iterator<T> inorderIterator() {
    Queue<T> queue = new LinkedList<T>();
    inorderTraverse(queue, root);
    return queue.iterator();
  }

  private void inorderTraverse(Queue<T> queue, BSTNode<T> node) {
    if (node != null) {
      inorderTraverse(queue, node.getLeft());
      queue.add(node.getData());
      inorderTraverse(queue, node.getRight());
    }
  }

  public Iterator<T> postorderIterator() {
    // TODO: Implement the postorderIterator() method
    return null;
  }

  @Override
  public boolean equals(BSTInterface<T> other) {
    // TODO: Implement the equals() method
    return false;
  }

  @Override
  public boolean sameValues(BSTInterface<T> other) {
    // TODO: Implement the sameValues() method
    return false;
  }

  @Override
  public boolean isBalanced() {
    // TODO: Implement the isBalanced() method
    return false;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void balance() {
    // TODO: Implement the balanceHelper() method
  }

  @Override
  public BSTNode<T> getRoot() {
    // DO NOT MODIFY
    return root;
  }

  public static <T extends Comparable<T>> String toDotFormat(BSTNode<T> root) {
    // header
    int count = 0;
    String dot = "digraph G { \n";
    dot += "graph [ordering=\"out\"]; \n";
    // iterative traversal
    Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
    queue.add(root);
    BSTNode<T> cursor;
    while (!queue.isEmpty()) {
      cursor = queue.remove();
      if (cursor.getLeft() != null) {
        // add edge from cursor to left child
        dot += cursor.getData().toString() + " -> " + cursor.getLeft().getData().toString() + ";\n";
        queue.add(cursor.getLeft());
      } else {
        // add dummy node
        dot += "node" + count + " [shape=point];\n";
        dot += cursor.getData().toString() + " -> " + "node" + count + ";\n";
        count++;
      }
      if (cursor.getRight() != null) {
        // add edge from cursor to right child
        dot += cursor.getData().toString() + " -> " + cursor.getRight().getData().toString() + ";\n";
        queue.add(cursor.getRight());
      } else {
        // add dummy node
        dot += "node" + count + " [shape=point];\n";
        dot += cursor.getData().toString() + " -> " + "node" + count + ";\n";
        count++;
      }
    }
    dot += "};";
    return dot;
  }

  public static void main(String[] args) {
    for (String r : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
      BSTInterface<String> tree = new BinarySearchTree<String>();
      for (String s : new String[] { "d", "b", "a", "c", "f", "e", "g" }) {
        tree.add(s);
      }
      Iterator<String> iterator = tree.inorderIterator();
      while (iterator.hasNext()) {
        System.out.print(iterator.next());
      }
      System.out.println();
      iterator = tree.preorderIterator();
      while (iterator.hasNext()) {
        System.out.print(iterator.next());
      }
      System.out.println();
      iterator = tree.postorderIterator();
      while (iterator.hasNext()) {
        System.out.print(iterator.next());
      }
      System.out.println();

      System.out.println(tree.remove(r));

      iterator = tree.inorderIterator();
      while (iterator.hasNext()) {
        System.out.print(iterator.next());
      }
      System.out.println();
    }

    BSTInterface<String> tree = new BinarySearchTree<String>();
    for (String r : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
      tree.add(r);
    }
    System.out.println(toDotFormat(tree.getRoot()));
    System.out.println(tree.size());
    System.out.println(tree.height());
    System.out.println(tree.isBalanced());
    tree.balance();
    System.out.println(tree.size());
    System.out.println(tree.height());
    System.out.println(tree.isBalanced());
  }
}
