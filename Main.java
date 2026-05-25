public class Main {

    public static void main(String[] args) {

        BankManager manager = new BankManager();

        while (true) {

            System.out.println("\n===== Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Check Balance");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(manager.sc.nextLine().trim());

            switch (choice) {

                case 1:
                    manager.createAccount();
                    break;

                case 2:
                    manager.viewAccounts();
                    break;

                case 3:
                    manager.searchAccount();
                    break;

                case 4:
                    manager.depositMoney();
                    break;

                case 5:
                    manager.withdrawMoney();
                    break;

                case 6:
                    manager.checkBalance();
                    break;

                case 7:
                    manager.deleteAccount();
                    break;

                case 8:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}