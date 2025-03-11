#include<iostream>
#include<string>
using namespace std;

class CurrencyConverter {
private:
    // Currency names
    string currencies[6] = {"USD", "EUR", "NPR", "INR", "JPY", "GBP"};
    // Conversion rates (row = initial currency, col = target currency)
    float rates[6][6] = {
        {1.0, 0.91, 132.0, 82.0, 145.0, 0.75},  // USD to others
        {1.1, 1.0, 144.0, 90.0, 159.0, 0.83},  // EUR to others
        {0.0076, 0.0069, 1.0, 0.62, 1.1, 0.0057},  // NPR to others
        {0.012, 0.011, 1.6, 1.0, 1.76, 0.0093},  // INR to others
        {0.0069, 0.0063, 1.0 / 1.1, 0.57, 1.0, 0.0052},  // JPY to others
        {1.33, 1.2, 176.0, 107.0, 193.0, 1.0}   // GBP to others
    };

public:
    void displayCurrencies() {
        cout << "\nAvailable currencies:\n";
        for (int i = 0; i < 6; i++) {
            cout << i + 1 << ". " << currencies[i] << endl;
        }
    }

    void convertCurrency() {
        int initial, target;
        float amount, converted;

        displayCurrencies();

        // User selects the initial currency
        cout << "Select the initial currency (enter the number): ";
        cin >> initial;
        if (initial < 1 || initial > 6) {
            cout << "Invalid selection! Please restart the program." << endl;
            return;
        }

        // User selects the target currency
        cout << "Select the target currency (enter the number): ";
        cin >> target;
        if (target < 1 || target > 6) {
            cout << "Invalid selection! Please restart the program." << endl;
            return;
        }

        // User inputs the amount to convert
        cout << "Enter the amount in " << currencies[initial - 1] << ": ";
        cin >> amount;

        // Conversion using the rates table
        converted = amount * rates[initial - 1][target - 1];

        // Display result
        cout << amount << " " << currencies[initial - 1] << " = " 
             << converted << " " << currencies[target - 1] << endl;
    }
};

int main() {
    CurrencyConverter converter;
    char repeat;

    do {
        converter.convertCurrency();
        cout << "\nDo you want to perform another conversion? (y/n): ";
        cin >> repeat;
    } while (repeat == 'y' || repeat == 'Y');

    cout << "Thank you for using the Currency Converter!" << endl;
    return 0;
}
