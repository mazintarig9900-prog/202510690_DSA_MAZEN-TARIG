public class Customer {
    private String name;
    private int pin;
    private BankAccount account;

    public Customer(String name, int pin, BankAccount account) {
        this.name = name;
        this.pin = pin;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }

    public boolean checkPin(int enteredPin) {
        return this.pin == enteredPin;
    }
}