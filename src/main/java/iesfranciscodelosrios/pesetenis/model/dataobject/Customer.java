package iesfranciscodelosrios.pesetenis.model.dataobject;

public class Customer extends Thread {

    /**
     * Attributes
     */
    private String customerName;
    private double amount;
    private String transactionType;
    private Account account;

    /**
     * Constructor with full params
     * @param name Customer name
     * @param amount Amount to carry out the transaction
     * @param transactionType Transaction to perform, enter or extract
     * @param account Customer account
     */
    public Customer(String name, double amount, String transactionType, Account account) {
        this.customerName = name;
        this.amount = amount;
        this.transactionType = transactionType;
        this.account = account;
    }

    /**
     * Getters and Setters
     */
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    /**
     * Run method overridden
     * Start a type of transaction
     */
    @Override
    public void run() {
        if(account.isTransaction()){
            synchronized (account){
                try {
                    account.wait();
                    account.setTransaction(false);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            if(transactionType.equals("enter")){
                account.enterBalance(amount);
            } else if(transactionType.equals("extract")) {
                account.drawBalance(amount);
            }
            account.setTransaction(true);
        }
    }
}
