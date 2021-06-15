package language;

public abstract class UnaryOperator<T> implements Operator<T> {

  protected Operand<T> op0;

  @Override
  public final int getNumberOfArguments() {
    return 1;
  }

  @Override
  public void setOperand(int i, Operand<T> operand) {
    // TODO: write the unary operator version of this method
  }

}
