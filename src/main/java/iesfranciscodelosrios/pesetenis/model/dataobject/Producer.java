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
}
