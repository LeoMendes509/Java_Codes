import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the user's name and greet
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "! Welcome, let's do some calculations! :)");

        // Receive two numbers with validation
        double num1 = getNumber(scanner, "Enter the first number: ");
        double num2 = getNumber(scanner, "Enter the second number: ");

        int operation;
        double result;

        // Main loop to allow repeated calculations
        while (true) {
            showMenu(); // Show the operation options
            operation = getOperation(scanner); // Read a valid operation
            result = performCalculation(num1, num2, operation); // Execute the chosen operation

            System.out.println("Result of the operation: " + result);

            // Ask if the user wants to perform another calculation
            System.out.print("\nDo you want to choose another operation? (Y/N): ");
            char choice = scanner.next().toUpperCase().charAt(0);
            if (choice != 'Y') {
                break; // Exit if the answer is not 'Y'
            }
        }

        System.out.println("\nThank you for using the calculator, " + name + "! See you next time.");
        scanner.close(); // Close the Scanner
    }

    // Display the menu with available operations
    private static void showMenu() {
        System.out.println("\nChoose the operation:");
        System.out.println("1 - Addition (+)");
        System.out.println("2 - Subtraction (-)");
        System.out.println("3 - Multiplication (*)");
        System.out.println("4 - Division (/)");
    }

    // Get a number with validation
    private static double getNumber(Scanner scanner, String message) {
        double number;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                scanner.nextLine(); // Clear buffer
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Discard invalid input
            }
        }
        return number;
    }

    // Get the operation option with validation
    private static int getOperation(Scanner scanner) {
        int operation;
        while (true) {
            System.out.print("Enter the desired operation (1-4): ");
            if (scanner.hasNextInt()) {
                operation = scanner.nextInt();
                if (operation >= 1 && operation <= 4) {
                    scanner.nextLine(); // Clear buffer
                    break;
                } else {
                    System.out.println("Invalid option! Choose a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                scanner.nextLine(); // Discard invalid input
            }
        }
        return operation;
    }

    // Perform the calculation based on the chosen operation
    private static double performCalculation(double num1, double num2, int operation) {
        return switch (operation) {
            case 1 -> num1 + num2; // Addition
            case 2 -> num1 - num2; // Subtraction
            case 3 -> num1 * num2; // Multiplication
            case 4 -> {
                if (num2 == 0) {
                    System.out.println("⚠️ Error: division by zero! Returning 0.");
                    yield 0;
                } else {
                    yield num1 / num2; // Division
                }
            }
            default -> 0; // This should never happen due to validation
        };
    }
}
