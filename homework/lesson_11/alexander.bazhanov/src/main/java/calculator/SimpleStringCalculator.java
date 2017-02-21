package calculator;

public class SimpleStringCalculator {
  public int add(String expression) {
    if (expression.isEmpty()) {
      return 0;
    } else if (containsNegativeNum(expression)) {
      return -1;
    } else {
      int[] intArray = new int[expression.length()];
      for (int i = 0; i < expression.length(); i++) {
        int count = i;
        while (count < expression.length() && isNum(expression.charAt(count))) {
          intArray[i] = intArray[i] * 10 + parseInt(expression.charAt(count));
          count++;
        }
        i = count;
      }
      return sumArrayWithoutThousands(intArray);
    }
  }

  private boolean isNum(char character) {
    if (character >= '0' && character <= '9') {
      return true;
    }
    return false;
  }

  private int parseInt(char character) {
    int unicodeBias = 48;
    return character - unicodeBias;
  }

  private int sumArrayWithoutThousands(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] < 1000) {
        sum += array[i];
      }
    }
    return sum;
  }

  private boolean containsNegativeNum(String expression) {
    return expression.contains("-");
  }
}
