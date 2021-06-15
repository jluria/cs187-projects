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
    for (Token<Integer> token : parser) {
      Type type = token.getType();
      switch (type) {
        case OPERAND:
          stack.push(token.getOperand());
          break;
        case OPERATOR:
          // TODO What do we do when we see an operator?
          Operator<Integer> operator = token.getOperator();
          Operand<Integer> newOperand = null;
          System.out.println("SUCCESS!~!!");
          System.out.println(operator);
          if (operator.getNumberOfArguments() == 1) {
            operator.setOperand(0, stack.pop());
            newOperand = operator.performOperation();
          } else {
            operator.setOperand(0, stack.pop());
            operator.setOperand(1, stack.pop());
            newOperand = operator.performOperation();
          }
          stack.push(newOperand);
          break;
        default:
          throw new IllegalStateException("Parser returned an invalid Type: " + type);
      }
    }
    Operand<Integer> finalResult = stack.pop();
    return finalResult.getValue();
  }
}
