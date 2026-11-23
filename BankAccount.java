public class BankAccount {
    private double balance;
    private String[] transactions;
    private int count;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactions = new String[100];
        this.count = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0 && count < transactions.length) {
            balance += amount;
            transactions[count++] = "Deposit: +" + amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Error: insufficient balance.");
        } else if (count >= transactions.length) {
            System.out.println("Transaction history is full.");
        } else {
            balance -= amount;
            transactions[count++] = "Withdraw: -" + amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public void showTransactions() {
        if (count == 0) {
            System.out.println("No transactions yet.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + transactions[i]);
        }
    }
}