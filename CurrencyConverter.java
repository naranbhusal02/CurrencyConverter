import java.util.Scanner;

public class CurrencyConverter {
    // Currency names
    static String[] currencies = {"USD", "EUR", "NPR", "INR", "JPY", "GBP"};
    // Conversion rates (row = initial currency, col = target currency)
    static double[][] rates = {
        {1.0, 0.91, 132.0, 82.0, 145.0, 0.75},  // USD to others
        {1.1, 1.0, 144.0, 90.0, 159.0, 0.83},  // EUR to others
        {0.0076, 0.0069, 1.0, 0.62, 1.1, 0.0057},  // NPR to others
        {0.012, 0.011, 1.6, 1.0, 1.76, 0.0093},  // INR to others
        {0.0069, 0.0063, 1.0 / 1.1, 0.57, 1.0, 0.0052},  // JPY to others
        {1.33, 1.2, 176.0, 107.0, 193.0, 1.0}   // GBP to others
    };

    public static void displayCurrencies() {
        System.out.println("\nAvailable currencies:");
        for (int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i]);
        }
    }

    public static void convertCurrency() {
        Scanner scanner = new Scanner(System.in);

        displayCurrencies();

        // User selects the initial currency
        System.out.print("Select the initial currency (enter the number): ");
        int initial = scanner.nextInt();
        if (initial < 1 || initial > currencies.length) {
            System.out.println("Invalid selection! Please restart the program.");
            return;
        }

        // User selects the target currency
        System.out.print("Select the target currency (enter the number): ");
        int target = scanner.nextInt();
        if (target < 1 || target > currencies.length) {
            System.out.println("Invalid selection! Please restart the program.");
            return;
        }

        // User inputs the amount to convert
        System.out.print("Enter the amount in " + currencies[initial - 1] + ": ");
        double amount = scanner.nextDouble();

        // Conversion using the rates table
        double converted = amount * rates[initial - 1][target - 1];

        // Display result
        System.out.println(amount + " " + currencies[initial - 1] + " = " + converted + " " + currencies[target - 1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char repeat;

        do {
            convertCurrency();
            System.out.print("\nDo you want to perform another conversion? (y/n): ");
            repeat = scanner.next().charAt(0);
        } while (repeat == 'y' || repeat == 'Y');

        System.out.println("Thank you for using the Currency Converter!");
    }
}
