public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;

    public static int id;
    private int accountID;

    private double balance;

    public BankAccount() {
        this.balance = 0;
        this.accountID = id;
    }

    private static double interestRate = DEFAULT_INTEREST_RATE;


    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return years * interestRate*this.balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
