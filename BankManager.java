import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {

    ArrayList<BankAccount> accounts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String fileName = "accounts.txt";

    // Constructor - Load Data
    BankManager() {
        loadAccounts();
    }

    // Save Accounts
    void saveAccounts() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (BankAccount account : accounts) {
                writer.write(account.accountNumber + "," +
                        account.accountHolderName + "," +
                        account.balance);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error Saving Data!");
        }
    }

    // Load Accounts
    void loadAccounts() {

        try {

            File file = new File(fileName);

            if (!file.exists()) {
                return;
            }

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int accountNumber =
                        Integer.parseInt(data[0]);

                String name = data[1];

                double balance =
                        Double.parseDouble(data[2]);

                accounts.add(
                        new BankAccount(accountNumber,
                                name,
                                balance)
                );
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error Loading Data!");
        }
    }

    // Create Account
    void createAccount() {

        System.out.print("Enter Account Number: ");
        int accountNumber =
                Integer.parseInt(sc.nextLine().trim());

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance =
                Double.parseDouble(sc.nextLine().trim());

        BankAccount account =
                new BankAccount(accountNumber, name, balance);

        accounts.add(account);

        saveAccounts();

        System.out.println("Account Created Successfully!");
    }

    // View Accounts
    void viewAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Found!");
        } else {

            for (BankAccount account : accounts) {
                account.displayAccount();
            }
        }
    }

    // Search Account
    void searchAccount() {

        System.out.print("Enter Account Number to Search: ");
        int accountNumber =
                Integer.parseInt(sc.nextLine().trim());

        boolean found = false;

        for (BankAccount account : accounts) {

            if (account.accountNumber == accountNumber) {

                account.displayAccount();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account Not Found!");
        }
    }

    // Deposit Money
    void depositMoney() {

        System.out.print("Enter Account Number: ");
        int accountNumber =
                Integer.parseInt(sc.nextLine().trim());

        boolean found = false;

        for (BankAccount account : accounts) {

            if (account.accountNumber == accountNumber) {

                System.out.print("Enter Amount to Deposit: ");
                double amount =
                        Double.parseDouble(sc.nextLine().trim());

                account.balance += amount;

                saveAccounts();

                System.out.println("Money Deposited Successfully!");
                System.out.println("Updated Balance: ₹" +
                        account.balance);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account Not Found!");
        }
    }

    // Withdraw Money
    void withdrawMoney() {

        System.out.print("Enter Account Number: ");
        int accountNumber =
                Integer.parseInt(sc.nextLine().trim());

        boolean found = false;

        for (BankAccount account : accounts) {

            if (account.accountNumber == accountNumber) {

                System.out.print("Enter Amount to Withdraw: ");
                double amount =
                        Double.parseDouble(sc.nextLine().trim());

                if (amount > account.balance) {

                    System.out.println("Insufficient Balance!");

                } else {

                    account.balance -= amount;

                    saveAccounts();

                    System.out.println("Money Withdrawn Successfully!");
                    System.out.println("Remaining Balance: ₹" +
                            account.balance);
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account Not Found!");
        }
    }

    // Check Balance
    void checkBalance() {

        System.out.print("Enter Account Number: ");
        int accountNumber =
                Integer.parseInt(sc.nextLine().trim());

        boolean found = false;

        for (BankAccount account : accounts) {

            if (account.accountNumber == accountNumber) {

                System.out.println("Current Balance: ₹" +
                        account.balance);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account Not Found!");
        }
    }

    // Delete Account
    void deleteAccount() {

        System.out.print("Enter Account Number to Delete: ");
        int accountNumber =
                Integer.parseInt(sc.nextLine().trim());

        boolean found = false;

        for (int i = 0; i < accounts.size(); i++) {

            if (accounts.get(i).accountNumber == accountNumber) {

                accounts.remove(i);

                saveAccounts();

                System.out.println("Account Deleted Successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account Not Found!");
        }
    }
}