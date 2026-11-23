import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount account = new BankAccount(1000);
        Customer customer = new Customer("Ahmed", 1234, account);

        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < 3 && !loggedIn) {
            System.out.print("Enter PIN: ");
            int pin = input.nextInt();
            if (customer.checkPin(pin)) {
                loggedIn = true;
            } else {
                attempts++;
                System.out.println("Wrong PIN. Attempts left: " + (3 - attempts));
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Exiting.");
            input.close();
            return;
        }

        System.out.println("Welcome, " + customer.getName());

        int choice = 0;
        while (choice != 5) {
            System.out.println("\n1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View transactions");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + customer.getAccount().getBalance());
                    break;
                case 2:
                    System.out.print("Amount: ");
                    customer.getAccount().deposit(input.nextDouble());
                    break;
                case 3:
                    System.out.print("Amount: ");
                    customer.getAccount().withdraw(input.nextDouble());
                    break;
                case 4:
                    customer.getAccount().showTransactions();
                    break;
                case 5:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        input.close();
    }
}