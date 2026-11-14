import java.util.*;
class BankAccount {
    int accountNumber;
    double balance;
    BankAccount(int number, double balance) {
        accountNumber = number;
        this.balance = balance;
    }
    double calculateFinalBalance() {
        return balance;
    }
}
class SavingsAccount extends BankAccount {
    double interestRate;
    SavingsAccount(int number, double balance, double rate) {
        super(number, balance);
        interestRate = rate;
    }
    @Override
    double calculateFinalBalance() {
        return balance + (balance * interestRate / 100);
    }
}
class CurrentAccount extends BankAccount {
    double overdraftLimit;
    CurrentAccount(int number, double balance, double limit) {
        super(number, balance);
        overdraftLimit = limit;
    }
    @Override
    double calculateFinalBalance() {
        return balance + overdraftLimit;
    }
}
public class BankingAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        int number = sc.nextInt();
        double balance = sc.nextDouble();
        BankAccount account;
        if (type == 1) {
            double rate = sc.nextDouble();
            account = new SavingsAccount(number, balance, rate);
        } else {
            double limit = sc.nextDouble();
            account = new CurrentAccount(number, balance, limit);
        }
        System.out.printf("%.2f%n", account.calculateFinalBalance());
    }
}
