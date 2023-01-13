package iesfranciscodelosrios.pesetenis.model.dataobject;

public class Account {

    /**
     * Attributes
     */
    private double balance;
    private boolean transaction;

    /**
     * Constructor with full params
     * @param balance Total account balance
     */
    public Account(double balance) {
        this.balance = balance;
        this.transaction = false;
    }

    /**
     * Default constructor
     */
    public Account() {
        this(200000);
        this.transaction=false;
    }

    /**
     * Getters and Setters
     */
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public boolean isTransaction() { return transaction; }
    public void setTransaction(boolean transaction) { this.transaction = transaction; }

    /**
     * Withdraws an amount from the account
     * @param amount Amount to withdraw
     * @return updated account balance, 0 -> no balance, -1 -> insufficient balance
     */
    public synchronized double drawBalance(double amount) {
        double initialBalance=this.balance;
        if(this.balance>0 && this.balance-amount>=0) {
            return this.balance -= amount;
        } else {
            if(this.balance==0){
                return 0; //the account has no balance
            } else {
                return -1; //insufficient account balance
            }
        }
    }

    /**
     * Increase account balance
     * @param amount Amount to increase
     * @return updated account balance
     */
    public synchronized double enterBalance(double amount) {
        double initialBalance=this.balance;
        return this.balance += amount;
    }
}