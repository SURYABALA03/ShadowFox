import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountHolder;
    private double balance;
    private List<String> transactions;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account opened with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds.");
        balance -= amount;
        transactions.add("Withdrew: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactions;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
