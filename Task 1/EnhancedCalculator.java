import java.util.Scanner;

public class EnhancedCalculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> basicOperations();
                case 2 -> scientificOperations();
                case 3 -> unitConversions();
                case 0 -> System.out.println("Exiting Calculator. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        } while (choice != 0);
    }

    static void showMainMenu() {
        System.out.println("==== Enhanced Calculator ====");
        System.out.println("1. Basic Arithmetic Operations");
        System.out.println("2. Scientific Operations");
        System.out.println("3. Unit Conversions");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // Basic Arithmetic Operations
    static void basicOperations() {
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        System.out.println("Choose operation (+ - * /): ");
        char op = scanner.next().charAt(0);
        double result;

        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                if (b == 0) {
                    System.out.println("Error: Division by zero");
                    return;
                }
                result = a / b;
            }
            default -> {
                System.out.println("Invalid operator.");
                return;
            }
        }

        System.out.println("Result: " + result);
    }

    // Scientific Operations
    static void scientificOperations() {
        System.out.println("Choose operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Power (x^y)");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                if (num < 0) {
                    System.out.println("Error: Cannot compute square root of negative number.");
                } else {
                    System.out.println("Square root: " + Math.sqrt(num));
                }
            }
            case 2 -> {
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exp = scanner.nextDouble();
                System.out.println("Result: " + Math.pow(base, exp));
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    // Unit Conversion
    static void unitConversions() {
        System.out.println("Choose conversion type:");
        System.out.println("1. Temperature (Celsius ↔ Fahrenheit)");
        System.out.println("2. Currency (USD ↔ INR)");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> temperatureConversion();
            case 2 -> currencyConversion();
            default -> System.out.println("Invalid choice.");
        }
    }

    static void temperatureConversion() {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();

        switch (choice) {
            case 1 -> System.out.println("Result: " + (temp * 9 / 5 + 32) + " °F");
            case 2 -> System.out.println("Result: " + ((temp - 32) * 5 / 9) + " °C");
            default -> System.out.println("Invalid choice.");
        }
    }

    static void currencyConversion() {
        final double USD_TO_INR = 83.0;  // mock rate
        System.out.println("1. USD to INR");
        System.out.println("2. INR to USD");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        switch (choice) {
            case 1 -> System.out.println("Result: ₹" + (amount * USD_TO_INR));
            case 2 -> System.out.println("Result: $" + (amount / USD_TO_INR));
            default -> System.out.println("Invalid choice.");
        }
    }
}

