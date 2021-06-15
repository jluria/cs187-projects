package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List
 * structure to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
  private int size = 0;
  private LLNode top = null;

  /** {@inheritDoc} */
  @Override
  public T pop() throws StackUnderflowException {
    // TODO: Implement the stack operation for `pop`!
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public T top() throws StackUnderflowException {
    // TODO: Implement the stack operation for `top`!
    return null;
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
    // TODO: Implement the stack operation for `push`!
  }
}
