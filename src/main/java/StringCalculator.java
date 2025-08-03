import java.util.Scanner;

public class StringCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        double result = stringCalculate(userInput);
        printResult(result);
    }

    public double stringCalculate(String scannerInput) {
        String[] inputs = parseInput(scannerInput);

        return calculate(inputs);
    }

    private String[] parseInput(String input) {
        return input.split(" ");
    }

    private double calculate(String[] inputs) {
        double operand1 = Integer.parseInt(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            String operator = inputs[i];
            double operand2 = Integer.parseInt(inputs[i + 1]);

            operand1 = customCalculator(operand1, operand2, operator);
        }

        return operand1;
    }

    private double customCalculator(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                operand1 += operand2;
                break;
            case "-":
                operand1 -= operand2;
                break;
            case "*":
                operand1 *= operand2;
                break;
            case "/":
                operand1 /= operand2;
                break;
            default:
                throw new StringIndexOutOfBoundsException();
        }
        return operand1;
    }

    private void printResult(double result) {
        System.out.println(result);
    }
}
