public class BankAccount {

    int accountNumber;
    String accountHolderName;
    double balance;
    int pin;

    // Constructor
    BankAccount(int accountNumber,
                String accountHolderName,
                double balance,
                int pin) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.pin = pin;
    }

    // Display Account Details
    void displayAccount() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
        System.out.println("---------------------------");
    }
}