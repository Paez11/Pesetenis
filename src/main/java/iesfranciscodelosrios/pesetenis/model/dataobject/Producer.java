package iesfranciscodelosrios.pesetenis.model.dataobject;

public class Producer extends Thread{
    private FileM fm;
    private Account account;
    private Customer customer;
    private String type;

    public Producer(FileM fm, Account account, Customer customer, String type) {
        this.fm = fm;
        this.account = account;
        this.customer = customer;
        this.type = type;
    }

    public void run(){
        fm.write(customer,account,type);
    }

    public FileM getFm() {
        return fm;
    }

    public void setFm(FileM fm) {
        this.fm = fm;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "fm=" + fm +
                ", account=" + account +
                ", customer=" + customer +
                ", type='" + type + '\'' +
                '}';
    }
}
