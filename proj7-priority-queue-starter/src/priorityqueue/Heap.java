package priorityqueue;

import java.lang.reflect.Array;
import java.util.Comparator;

public class Heap<T> implements PriorityQueueADT<T> {

  private int numElements;
  private T[] heap;
  private boolean isMaxHeap;
  private Comparator<T> comparator;
  private final static int INIT_SIZE = 5;

  /**
   * Constructor for the heap.
   *
   * @param comparator comparator object to define a sorting order for the heap
   *                   elements.
   * @param isMaxHeap  Flag to set if the heap should be a max heap or a min heap.
   */
  public Heap(Comparator<T> comparator, boolean isMaxHeap) {
    this.numElements = 0;
    this.heap = (T[]) new Object[INIT_SIZE];
    this.comparator = comparator;
    this.isMaxHeap = isMaxHeap;
  }

  /**
   * This results in the entry at the specified index "bubbling up" to a location
   * such that the property of the heap are maintained. This method should run in
   * O(log(size)) time. Note: When enqueue is called, an entry is placed at the
   * next available index in the array and then this method is called on that
   * index.
   *
   * @param index the index to bubble up
   */
  public void bubbleUp(int index) {
    int parentIndex = (index - 1) / 2;
    if (index == 0)
      return;
    if (compare(heap[parentIndex], heap[index]) < 0) {
      T temp = heap[index];
      heap[index] = heap[parentIndex];
      heap[parentIndex] = temp;
      bubbleUp(parentIndex);
    }
  }

  /**
   * This method results in the entry at the specified index "bubbling down" to a
   * location such that the property of the heap are maintained. This method
   * should run in O(log(size)) time. Note: When remove is called, if there are
   * elements remaining in this the bottom most element of the heap is placed at
   * the 0th index and bubbleDown(0) is called.
   *
   * @param index
   */
  public void bubbleDown(int index) {
    int preferableChild = bdSwapIndex((index * 2) + 1, (index * 2) + 2);
    T temp;

    if (preferableChild == -1) {
      return;
    } else {
      if (compare(heap[preferableChild], heap[index]) > 0) {
        temp = heap[preferableChild];
        heap[preferableChild] = heap[index];
        heap[index] = temp;
        bubbleDown(preferableChild);
      }
    }
  }

  /**
   *
   * @param left  potential left child index
   * @param right potential right child index
   * @return most appropriate index to check for swapping with parent node
   */
  public int bdSwapIndex(int left, int right) {
    int chosenIndex = -1;

    if (right >= size() && left < size()) {
      chosenIndex = left;
    }

    if (right < size() && left < size()) {
      if (compare(heap[left], heap[right]) > 0) {
        chosenIndex = left;
      } else if (compare(heap[right], heap[left]) >= 0) {
        chosenIndex = right;
      }
    }

    return chosenIndex;
  }

  /**
   * Test for if the queue is empty.
   *
   * @return true if queue is empty, false otherwise.
   */
  public boolean isEmpty() {
    boolean isEmpty = false;
    if (size() <= 0) {
      isEmpty = true;
    }
    return isEmpty;
  }

  /**
   * Number of data elements in the queue.
   *
   * @return the size
   */
  public int size() {
    int size = -100;
    if (numElements >= 0) {
      size = numElements;
    }
    return size;
  }

  /**
   * Compare method to implement max/min heap behavior. It calls the comparae
   * method from the comparator object and multiply its output by 1 and -1 if max
   * and min heap respectively. TODO: implement the heap compare method
   *
   * @param element1 first element to be compared
   * @param element2 second element to be compared
   * @return positive int if {@code element1 > element2}, 0 if
   *         {@code element1 == element2}, negative int otherwise
   */
  public int compare(T element1, T element2) {
    int result = 0;
    int compareSign = -1;
    if (isMaxHeap) {
      compareSign = 1;
    }
    result = compareSign * comparator.compare(element1, element2);
    return result;
  }

  /**
   * Return the element with highest (or lowest if min heap) priority in the heap
   * without removing the element.
   *
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T peek() throws QueueUnderflowException {
    T data = null;
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }
    data = heap[0];

    return data;
  }

  /**
   * Removes and returns the element with highest (or lowest if min heap) priority
   * in the heap.
   *
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T dequeue() throws QueueUnderflowException {
    T data = null;
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }

    data = heap[0];
    heap[0] = heap[size() - 1];
    heap[size() - 1] = null;
    numElements--;
    bubbleDown(0);

    return data;
  }

  /**
   * Enqueue the element.
   *
   * @param the new element
   */
  public void enqueue(T newElement) {
    if (size() == heap.length)
      heap = increaseHeapSize(heap);
    heap[size()] = newElement;
    bubbleUp(size());
    numElements++;
  }

  /**
   *
   * @param fullHeap is the heap when there is no available index
   * @return a heap twice the size of the original, with the previous entries
   *         making up the first half of the new heap
   */

  public T[] increaseHeapSize(T[] fullHeap) {
    T[] newHeap = (T[]) new Object[fullHeap.length * 2];
    for (int i = 0; i < fullHeap.length; i++) {
      newHeap[i] = fullHeap[i];
    }
    return newHeap;
  }

}
