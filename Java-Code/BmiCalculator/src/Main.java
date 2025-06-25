import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Greeting message
        System.out.println("Welcome to the BMI calculator!");

        // Name validation
        String name;
        while (true) {
            System.out.print("Enter your name (letters only): ");
            name = scanner.nextLine();
            if (name.matches("[a-zA-Záàâãéèêíïóôõöúç]+( [a-zA-Záàâãéèêíïóôõöúç]+)*")) {
                break;
            } else {
                System.out.println("Invalid name. Please enter letters only.");
            }
        }

        // Height validation
        double height;
        while (true) {
            System.out.print("Enter your height (e.g., 1.75 or 1,75): ");
            String heightInput = scanner.nextLine().replace(',', '.');  // Replace comma with dot
            try {
                height = Double.parseDouble(heightInput);
                if (height > 0) {
                    break;
                } else {
                    System.out.println("Invalid height. Height must be greater than zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid height. Please enter a valid number.");
            }
        }

        // Weight validation
        double weight;
        while (true) {
            System.out.print("Enter your weight (e.g., 70.5 or 70,5): ");
            String weightInput = scanner.nextLine().replace(',', '.');  // Replace comma with dot
            try {
                weight = Double.parseDouble(weightInput);
                if (weight > 0) {
                    break;
                } else {
                    System.out.println("Invalid weight. Weight must be greater than zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid weight. Please enter a valid number.");
            }
        }

        // Calculate BMI
        double bmi = weight / (height * height);
        System.out.printf("%s, your BMI is: %.2f\n", name, bmi);

        // BMI classification
        if (bmi < 16) {
            System.out.printf("%s, your BMI is: %.2f. Classification: Severe Thinness\n", name, bmi);
        } else if (bmi >= 16.0 && bmi <= 16.9) {
            System.out.printf("%s, your BMI is: %.2f. Classification: Moderate Thinness\n", name, bmi);
        } else if (bmi >= 17.0 && bmi <= 18.4) {
            System.out.printf("%s, your BMI is: %.2f. Classification: Mild Thinness\n", name, bmi);
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.printf("%s, your BMI is: %.2f. Classification: Normal weight\n", name, bmi);
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            System.out.printf("%s, your BMI is: %.2f. Classification: Overweight\n", name, bmi);
        } else if (bmi >= 30.0 && bmi <= 34.9) {
            System.out.printf("%s, your BMI is: %.2f. Classification: Obesity class I\n", name, bmi);
        } else if (bmi >= 35.0 && bmi <= 39.9) {
            System.out.printf("%s, your BMI is: %.2f. Classification: Obesity class II (severe)\n", name, bmi);
        } else {
            System.out.printf("%s, your BMI is: %.2f. Classification: Obesity class III (morbid)\n", name, bmi);
        }

        scanner.close();
    }
}
