import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new AccountBank object
        AccountBank account = new AccountBank();

        // Input account information
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        account.setAccountNumber(accountNumber);

        System.out.println("Enter account holder name:");
        String accountHolderName = scanner.nextLine();
        account.setAccountHolderName(accountHolderName);

        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();
        account.setBalance(initialBalance);

        // Display account information
        System.out.println("Account created successfully.");
        account.displayAccountInfo();

        // Testing transactions
        System.out.println("\nPerforming transactions:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Exit");

        int choice;
        do {
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    account.displayAccountInfo();
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    account.displayAccountInfo();
                    break;
                case 3:
                    System.out.println("Enter destination account number:");
                    String destinationAccountNumber = scanner.next();
                    AccountBank destinationAccount = new AccountBank();
                    destinationAccount.setAccountNumber(destinationAccountNumber);

                    System.out.println("Enter transfer amount:");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(destinationAccount, transferAmount);
                    account.displayAccountInfo();
                    System.out.println("Destination account information:");
                    destinationAccount.displayAccountInfo();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
