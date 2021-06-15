package language.arith;

import language.BinaryOperator;
import language.Operand;

/**
 * The {@code SubOperator} is an operator that performs subtraction on two
 * integers.
 */
public class SubOperator extends BinaryOperator<Integer> {
  /** {@inheritDoc} */
  @Override
  public Operand<Integer> performOperation() {
    if (op0 == null || op1 == null)
      throw new IllegalStateException("Could not perform subtraction operation prior to operands being set.");
    Integer result = op1.getValue() - op0.getValue();
    return new Operand<Integer>(result);
  }

  public String toString() {
    return "-";
  }
}
