package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.PostfixEvaluator;
import java.lang.Integer;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple
 * arithmetic expressions.
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

  private final LinkedStack<Operand<Integer>> stack;

  /** Constructs an {@link ArithPostfixEvaluator} */
  public ArithPostfixEvaluator() {
    stack = new LinkedStack<Operand<Integer>>();
  }

  /** {@inheritDoc} */
  @Override
  public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
    ArithPostfixParser parser = new ArithPostfixParser(expr);
    boolean operatorSeen = false;
    int operandCount = 0;
    for (Token<Integer> token : parser) {
      Type type = token.getType();
      switch (type) {
        case OPERAND:
          operandCount++;
          stack.push(token.getOperand());
          break;
        case OPERATOR:
          operatorSeen = true;
          Operator<Integer> operator = token.getOperator();
          Operand<Integer> newOperand = null;
          if (operator.getNumberOfArguments() == 1) {
            operator.setOperand(0, stack.pop());
            newOperand = operator.performOperation();
          } else {
            operator.setOperand(1, stack.pop());
            operator.setOperand(0, stack.pop());
            newOperand = operator.performOperation();
          }
          stack.push(newOperand);
          break;
        default:
          throw new IllegalStateException("Parser returned an invalid Type: " + type);
      }
    }
    if (!operatorSeen && operandCount > 1) {
      throw new IllegalPostfixExpressionException();
    }
    Operand<Integer> finalResult = stack.pop();
    return finalResult.getValue();
  }
}
