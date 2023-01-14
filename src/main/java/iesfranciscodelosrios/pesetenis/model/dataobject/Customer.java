package iesfranciscodelosrios.pesetenis.model.dataobject;

import iesfranciscodelosrios.pesetenis.utils.Operation;

public class Customer extends Operation implements Runnable {

    /**
     * Attributes
     */
    private String customerName;
    private double amount;

    /**
     * Constructor with full params
     * @param name Customer name
     * @param amount Amount to carry out the transaction
     */
    public Customer(String name, double amount) {
        this.customerName = name;
        this.amount = amount;
    }

    /**
     * Getters and Setters
     */
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    /**
     * Run method overridden
     * Start a type of transaction
     */
    @Override
    public void run() {
        if(opsAccount.isTransaction()){
            synchronized (opsAccount){
                try {
                    opsAccount.wait();
                    opsAccount.setTransaction(false);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            if(opsTransactionType.equals("enter")){
                opsAccount.enterBalance(amount);
            } else if(opsTransactionType.equals("extract")) {
                opsAccount.drawBalance(amount);
            }
            opsAccount.setTransaction(true);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", transactionType='" + opsTransactionType + '\'' +
                ", account=" + opsAccount +
                '}';
    }
}
