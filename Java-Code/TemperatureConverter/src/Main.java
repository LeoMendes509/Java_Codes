import java.util.Scanner;

public class Main {

    // Message constants
    private static final String INVALID_NAME_MESSAGE = "Invalid name. Please enter only letters and spaces.";
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter a valid number for the temperature.";
    private static final String PROGRAM_TITLE = "=== TEMPERATURE CONVERTER ===";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Program header
        System.out.println(PROGRAM_TITLE);

        // Request and validate user name
        String name = getValidName(scanner);
        System.out.println("Hello " + name + ", welcome to the temperature converter!");

        // Request and validate temperature in Fahrenheit
        double temperatureFahrenheit = getValidTemperature(scanner);

        // Convert to Celsius
        double temperatureCelsius = convertFahrenheitToCelsius(temperatureFahrenheit);

        // Display formatted result
        System.out.printf("%.2f°F is equivalent to %.2f°C%n", temperatureFahrenheit, temperatureCelsius);

        // Finish
        System.out.println("Thank you for using the converter, " + name + "!");
        scanner.close();
    }

    // Method to validate the name (letters and spaces only)
    private static String getValidName(Scanner scanner) {
        String name;
        while (true) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine().trim();

            if (name.matches("[A-Za-zÀ-ÿ ]+")) {
                return name;
            }
            System.out.println(INVALID_NAME_MESSAGE);
        }
    }

    // Method to validate the temperature input (must be a number)
    private static double getValidTemperature(Scanner scanner) {
        while (true) {
            System.out.print("Enter the temperature in Fahrenheit: ");
            String input = scanner.nextLine().trim();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println(INVALID_INPUT_MESSAGE);
            }
        }
    }

    // Method for Fahrenheit → Celsius conversion
    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}
