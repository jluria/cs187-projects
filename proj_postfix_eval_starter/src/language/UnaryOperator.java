package language;

public abstract class UnaryOperator<T> implements Operator<T> {

  protected Operand<T> op0;

  @Override
  public final int getNumberOfArguments() {
    return 1;
  }

  @Override
  public void setOperand(int i, Operand<T> operand) {
    if (operand == null)
      throw new NullPointerException("Could not set null operand.");
    if (i > 0) {
      throw new IllegalArgumentException("Unary operator only accepts operand 0 but received " + i + ".");
    } else {
      if (op0 != null)
        throw new IllegalStateException("Postion " + i + " has been previously set.");
      op0 = operand;
    }
  }

}
