import java.util.Scanner; // Imports the Scanner class to read input from the console

public class Main {

    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Request and store the customer's name
        String name = requestName(scanner);

        // Request and store the selected account type
        String accountType = selectAccountType(scanner);

        // Request and store the initial balance
        double balance = requestInitialBalance(scanner);

        // Display a summary of the customer's information
        displayCustomerSummary(name, accountType, balance);

        int option; // Variable to control the menu option

        // Main menu loop, only stops when the user enters 4 (exit)
        do {
            displayMenu(); // Shows the menu options
            option = scanner.nextInt(); // Reads the user's option

            // Executes different actions depending on the option
            switch (option) {
                case 1 -> checkBalance(balance); // Shows current balance
                case 2 -> balance = transferAmount(scanner, balance); // Performs transfer
                case 3 -> balance = receiveAmount(scanner, balance); // Performs deposit
                case 4 -> System.out.println("Exiting system. Thank you for using our service!");
                default -> System.out.println("⚠️  Invalid option. Please try again.");
            }
        } while (option != 4); // Repeats menu until option 4 is selected

        scanner.close(); // Close the scanner at the end
    }

    // Method to request customer's name
    public static String requestName(Scanner scanner) {
        System.out.print("Enter your name: ");
        return scanner.nextLine(); // Reads full name (including spaces)
    }

    // Method for user to choose the account type
    public static String selectAccountType(Scanner scanner) {
        System.out.println("\nChoose your account type:");
        System.out.println("1 - Checking Account");
        System.out.println("2 - Savings Account");
        System.out.println("3 - Payroll Account");
        System.out.println("4 - Digital Account");
        System.out.println("5 - Investment Account");
        System.out.print("Option: ");

        // Ensures that input is a number
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number for the account type: ");
            scanner.next();
        }

        int option = scanner.nextInt(); // Read the option
        scanner.nextLine(); // Consume the pending newline

        // Return account type based on selected option
        return switch (option) {
            case 1 -> "Checking Account";
            case 2 -> "Savings Account";
            case 3 -> "Payroll Account";
            case 4 -> "Digital Account";
            case 5 -> "Investment Account";
            default -> {
                System.out.println("⚠️  Invalid option. Account type not defined.");
                yield "Unknown"; // Return default if invalid option
            }
        };
    }

    // Method to request initial balance
    public static double requestInitialBalance(Scanner scanner) {
        System.out.print("\nEnter your bank balance: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid amount for the balance: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    // Displays customer data (name, account type, and balance)
    public static void displayCustomerSummary(String name, String accountType, double balance) {
        System.out.println("\n**********************************");
        System.out.println("Hello, " + name);
        System.out.println("Account type: " + accountType);
        System.out.printf("Current balance: $ %.2f\n", balance);
        System.out.println("**********************************");
    }

    // Displays the main operations menu
    public static void displayMenu() {
        System.out.println("""
                
                ========================
                Choose an option:
                1 - Check balance
                2 - Transfer amount
                3 - Receive amount
                4 - Exit
                ========================
                """);
        System.out.print("Enter your option: ");
    }

    // Shows the current balance
    public static void checkBalance(double balance) {
        System.out.printf("💰 Current balance: $ %.2f\n", balance);
    }

    // Method to perform a transfer
    public static double transferAmount(Scanner scanner, double balance) {
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("⚠️  Invalid amount. Please enter a positive number.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient funds for transfer.");
        } else {
            balance -= amount;
            System.out.printf("✅ Transfer of $ %.2f completed.\n", amount);
            System.out.printf("💰 Current balance: $ %.2f\n", balance);
        }

        return balance;
    }

    // Method to receive an amount (deposit)
    public static double receiveAmount(Scanner scanner, double balance) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("⚠️  Invalid amount. Please enter a positive number.");
        } else {
            balance += amount;
            System.out.printf("✅ Amount of $ %.2f received successfully.\n", amount);
            System.out.printf("💰 Current balance: $ %.2f\n", balance);
        }

        return balance;
    }
}
