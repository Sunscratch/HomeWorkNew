package algo.eval;

import algo.stack.LinkedListStack;

import algo.stack.Stack;

public class Expression {
  private Stack<Character> operators = new LinkedListStack<>();
  private Stack<Double> operands = new LinkedListStack<>();

  public double evaluate(String exprStr) {
    for (int i = 0; i < exprStr.length(); i++) {
      if (Character.isDigit(exprStr.charAt(i))) {
        double num = 0;
        while (Character.isDigit(exprStr.charAt(i))) {
          num = num * 10 + getDouble(exprStr.charAt(i));
          i++;
        }
        i--;
        operands.push(num);
      } else if ("+-/*".indexOf(exprStr.charAt(i)) != -1) {
        operators.push(exprStr.charAt(i));
      } else if (exprStr.charAt(i) == ')') {
        double result = operands.pop();
        Character operator = operators.pop();
        switch (operator) {
          case '+': result += operands.pop();
            break;
          case '-': result = operands.pop() - result;
            break;
          case '*': result *= operands.pop();
            break;
          case '/': result = operands.pop() / result;
            break;
          default: System.out.println("Something is wrong");
        }
        operands.push(result);
      }
    }
    return operands.pop();
  }

  private double getDouble(Character character) {
    return Double.parseDouble(Character.toString(character));
  }
}
