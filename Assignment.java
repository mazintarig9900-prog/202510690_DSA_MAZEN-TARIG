import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String username = input.nextLine();

        int CORRECT_PIN = 1234;
        int MAX_ATTEMPTS = 3;
        int attempts = 0;
        Boolean LoggedIn = false;

        // ========= Log in =========
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter Your PIN: ");
            int enteredPin = input.nextInt();
            if (enteredPin == CORRECT_PIN) {
                LoggedIn = true;
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts remaining: " + (MAX_ATTEMPTS - attempts));
            }
        }

        if (LoggedIn) {
            System.out.println("Access granted. Welcome, " + username + "!");
        } else {
            System.out.println("Access denied. Maximum attempts reached.");
            return;
        }

        // ========= User data =========
        double balance = 0;
        String[] history = new String[100];
        int count = 0;
        int choice;

        // ========= Main menu =========
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();

            switch (choice) {

                // ===== Check balance =====
                case 1:
                    System.out.println("Your balance: " + balance);
                    break;

                // ===== Deposit =====
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = input.nextDouble();
                    if (deposit > 0 && count < history.length) {
                        balance += deposit;
                        history[count] = "Deposit: " + deposit;
                        count++;
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                // ===== Withdraw =====
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = input.nextDouble();
                    if (withdraw > 0 && withdraw <= balance && count < history.length) {
                        balance -= withdraw;
                        history[count] = "Withdraw: " + withdraw;
                        count++;
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Error: insufficient balance or invalid amount.");
                    }
                    break;

                // ===== View transactions =====
                case 4:
                    if (count == 0) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + history[i]);
                        }
                    }
                    break;

                // ===== Exit =====
                case 5:
                    System.out.println("Goodbye, " + username + "!");
                    break;

                // ===== Invalid choice =====
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
    }
}