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
     * @param name Customer name
     * @param amount Amount to withdraw
     */
    public synchronized void drawBalance(String name, double amount) {
        double initialBalance=this.balance;
        if(this.balance>0 && this.balance-amount>=0) {
            this.balance -= amount;
            //Mostar saldo inicial en cuenta y disponible tras operacion

        } else {
            if(this.balance==0){
                //No se puede retirar cantidad, saldo 0

            } else {
                //saldo insuficiente

            }
        }
    }

    /**
     * Increase account balance
     * @param @param name Customer name
     * @param amount Amount to increase
     */
    public synchronized void enterBalance(String name, double amount) {
        double initialBalance=this.balance;
        this.balance += amount;
        //Mostar saldo inicial en cuenta y disponible tras operacion
    }
}