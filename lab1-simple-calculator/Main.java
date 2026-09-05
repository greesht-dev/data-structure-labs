import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Simple Calculator");
        System.out.println("Enter numbers and operators one at a time.");
        System.out.println("Enter exit to quit.");

        while (true) {
            String value = input.nextLine();

            if (value.equalsIgnoreCase("exit")) {
                break;
            }

            if (value.equals("=")) {
                System.out.println(calculator.getResult());
            } else if (value.equals("+") || value.equals("-")
                    || value.equals("*") || value.equals("/")) {
                calculator.inputOperator(value);
                System.out.println(calculator.getResult());
            } else {
                try {
                    double number = Double.parseDouble(value);
                    calculator.inputNumber(number);
                    System.out.println(calculator.getResult());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
            }
        }

        input.close();
    }
}