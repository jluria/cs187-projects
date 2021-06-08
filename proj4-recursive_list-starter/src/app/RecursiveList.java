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

    return removedItem;
  }

  @Override
  public T removeLast() {
    T removedItem = null;
    // TODO: Implement this method.

    return removedItem;
  }

  @Override
  public T removeAt(int i) {
    T removedItem = null;
    // TODO: Implement this method.

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
    Node<T> potentialLast = null;
    if (this.head != null) {
      potentialLast = this.head;
      while (potentialLast.getNext() != null) {
        potentialLast = potentialLast.getNext();
      }
      item = potentialLast.getData();
    } else {
      throw new IllegalStateException();
    }

    return item;
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
