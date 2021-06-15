package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List
 * structure to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
  private int size = 0;
  private LLNode<T> top = null;

  /** {@inheritDoc} */
  @Override
  public T pop() throws StackUnderflowException {
    if (this.isEmpty()) {
      throw new StackUnderflowException("Cannot pop a stack with no items");
    }
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public T top() throws StackUnderflowException {
    if (this.isEmpty()) {
      throw new StackUnderflowException("Cannot top a stack that is empty");
    }
    return top.getData();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    boolean isEmpty = false;
    if (size() == 0) {
      isEmpty = true;
    }
    return isEmpty;
  }

  /** {@inheritDoc} */
  @Override
  public int size() {
    int size = this.size;
    return size;
  }

  /** {@inheritDoc} */
  @Override
  public void push(T elem) {
    LLNode<T> newTop = new LLNode<T>(elem);
    if (this.top != null) {
      newTop.setNext(this.top);
    }
    this.top = newTop;
    size++;
  }
}
