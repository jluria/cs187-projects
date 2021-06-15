package language.arith;

import language.Operand;
import language.UnaryOperator;

/**
 * The {@code NegateOperator} is an operator that performs negation on a single
 * integer
 */

public class NegateOperator extends UnaryOperator<Integer> {
  @Override
  public Operand<Integer> performOperation() {
    if (op0 == null)
      throw new IllegalStateException("Could not perform negation operation prior to operand being set.");
    Integer result = -1 * op0.getValue();
    return new Operand<Integer>(result);
  }

  public String toString() {
    return "!";
  }
}
