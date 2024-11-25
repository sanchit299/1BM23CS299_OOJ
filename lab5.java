import java.util.Scanner;

class Account {
    String customerName;
    String accountNum;
    double balance;

    public Account(String customerName, String accountNum, double balance) {
        this.customerName = customerName;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid request or insufficient funds");
        }
    }

    public void display() {
        System.out.println("The balance is: " + balance);
    }
}

class SavAcc extends Account {
    double interestRate;

    public SavAcc(String customerName, String accountNum, double balance, double interestRate) {
        super(customerName, accountNum, balance);
        this.interestRate = interestRate;
    }

    public void compoundInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest compounded: " + interest);
    }
}

class CurAcc extends Account {
    static final double MIN_BAL = 1000;
    static final double SERVICE_CHARGE = 100;

    public CurAcc(String customerName, String accountNum, double balance) {
        super(customerName, accountNum, balance);
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            checkMinBalance();
        } else {
            System.out.println("Invalid request or insufficient balance");
        }
    }

    public void checkMinBalance() {
        if (balance < MIN_BAL) {
            balance -= SERVICE_CHARGE;
            System.out.println("Minimum balance not maintained. Service charge imposed: " + SERVICE_CHARGE);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name for savings account: ");
        String savName = scanner.nextLine();
        System.out.print("Enter account number for savings account: ");
        String savAccNum = scanner.nextLine();
        System.out.print("Enter initial balance for savings account: ");
        double savBalance = scanner.nextDouble();
        System.out.print("Enter interest rate for savings account: ");
        double savInterestRate = scanner.nextDouble();

        scanner.nextLine();

        SavAcc savings = new SavAcc(savName, savAccNum, savBalance, savInterestRate);
        savings.display();

        System.out.print("Enter the amount to deposit in savings account: ");
        savings.deposit(scanner.nextDouble());
        savings.display();

        System.out.print("Enter the amount to withdraw from savings account: ");
        savings.withdraw(scanner.nextDouble());
        savings.display();

        savings.compoundInterest();
        savings.display();

        System.out.print("\nEnter customer name for current account: ");
        String currName = scanner.nextLine();
        System.out.print("Enter account number for current account: ");
        String currAccNum = scanner.nextLine();
        System.out.print("Enter initial balance for current account: ");
        double currBalance = scanner.nextDouble();

        scanner.nextLine();

        CurAcc current = new CurAcc(currName, currAccNum, currBalance);
        current.display();

        System.out.print("\nEnter the amount to deposit in current account: ");
        current.deposit(scanner.nextDouble());
        current.display();

        System.out.print("Enter the amount to withdraw from current account: ");
        current.withdraw(scanner.nextDouble());
        current.display();

        scanner.close();
    }
}