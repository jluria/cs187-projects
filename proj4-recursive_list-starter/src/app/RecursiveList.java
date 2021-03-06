package app;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

  private int size;
  private Node<T> head = null;

  public RecursiveList() {
    this.head = null;
    this.size = 0;
  }

  public RecursiveList(Node<T> first) {
    this.head = first;
    this.size = 1;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void insertFirst(T elem) {
    head = new Node(elem, head);
    size++;
  }

  @Override
  public void insertLast(T elem) {
    if (head == null) {
      head = new Node(elem, null);
    } else {
      insertLastHelper(elem, head);
    }
    size++;

  }

  private void insertLastHelper(T elem, Node<T> current) {
    LinkedNodeIterator nodeIterator = new LinkedNodeIterator<T>(current.getNext());
    if (nodeIterator.hasNext() == false) {
      current.setNext(new Node(elem, null));
    } else {
      insertLastHelper(elem, current.getNext());
    }

  }

  @Override
  public void insertAt(int index, T elem) {
    // TODO: Implement this method.

  }

  @Override
  public T removeFirst() throws IllegalStateException {
    T removedItem = null;
    if (this.head == null) {
      throw new IllegalStateException();
    } else {
      removedItem = this.head.getData();
      this.head = this.head.getNext();
    }
    size--;

    return removedItem;
  }

  @Override
  public T removeLast() throws NullPointerException {
    T removedItem = null;
    Node<T> currentNode = head, prevNode = null;

    if (head == null) {
      throw new NullPointerException();
    }

    if (head.getNext() == null) {
      removedItem = head.getData();
      head = null;
      currentNode = null;
    }
    while (currentNode != null && currentNode.getNext() != null) {
      prevNode = currentNode;
      currentNode = currentNode.getNext();
    }
    if (prevNode != null) {
      prevNode.setNext(null);
    }
    if (currentNode != null) {
      removedItem = currentNode.getData();
    }
    size--;

    return removedItem;
  }

  @Override
  public T removeAt(int i) throws IndexOutOfBoundsException {
    T removedItem = null;
    Node<T> currentNode = head, prevNode = null;
    int position = 0;

    if (head == null || (i + 1) > size()) {
      throw new IndexOutOfBoundsException();
    }

    while (position < i) {
      prevNode = currentNode;
      currentNode = currentNode.getNext();
      position++;
    }

    removedItem = currentNode.getData();
    prevNode.setNext(currentNode.getNext());

    return removedItem;
  }

  @Override
  public T getFirst() throws IllegalStateException {
    T item = null;
    if (head == null) {
      throw new IllegalStateException();
    } else {
      item = head.getData();
    }

    return item;
  }

  @Override
  public T getLast() throws IllegalStateException {
    T item = null;
    if (head == null) {
      throw new IllegalStateException();
    } else {
      Iterator<T> iter = iterator();
      item = getLastHelper(iter);
    }

    return item;
  }

  private T getLastHelper(Iterator<T> iter) {
    T last = null;
    last = iter.next();
    if (iter.hasNext()) {
      last = getLastHelper(iter);
    }
    return last;
  }

  @Override
  public T get(int i) {
    T item = null;
    // TODO: Implement this method.

    return item;
  }

  @Override
  public void remove(T elem) {
    // TODO: Implement this method.

  }

  @Override
  public int indexOf(T elem) {
    int index = -1;
    // TODO: Implement this method.

    return index;
  }

  @Override
  public boolean isEmpty() {
    boolean empty = false;
    if (this.size == 0) {
      empty = true;
    }

    return empty;
  }

  public Iterator<T> iterator() {
    Iterator<T> iter = new LinkedNodeIterator<>(head);

    return iter;
  }
}
