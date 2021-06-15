package language.arith;

import language.Operand;
import language.UnaryOperator;

/**
 * The {@code NegateOperator} is an operator that performs negation on a single
 * integer
 */

public class NegateOperator extends UnaryOperator<Integer> {
  // TODO: You will notice that this class extends BinaryOperator.
  // That is not correct as negate is a unary operator. You should first
  // write an abstract class called UnaryOperator, paralleling
  // BinaryOperator, that abstracts out all the bits common
  // across UnaryOperators.
  @Override
  public Operand<Integer> performOperation() {
    // TODO: implement the negateoperator version of this method
    return null;
  }
}
