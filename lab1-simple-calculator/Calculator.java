public class Calculator {
    private double result;
    private String operator;

    public Calculator() {
        result = 0;
        operator = "";
    }

    public void inputNumber(double number) {
        if (operator.equals("")) {
            result = number;
        } else {
            calculate(number);
        }
    }

    public void inputOperator(String op) {
        operator = op;
    }

    private void calculate(double number) {
        if (operator.equals("+")) {
            result = result + number;
        } else if (operator.equals("-")) {
            result = result - number;
        } else if (operator.equals("*")) {
            result = result * number;
        } else if (operator.equals("/")) {
            if (number != 0) {
                result = result / number;
            } else {
                System.out.println("Cannot divide by zero.");
            }
        }

        operator = "";
    }

    public double getResult() {
        return result;
    }
}