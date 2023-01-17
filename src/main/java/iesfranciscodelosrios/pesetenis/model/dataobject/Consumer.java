package iesfranciscodelosrios.pesetenis.model.dataobject;

public class Consumer extends Thread {
    private FileM fm;
    private String filter;
    private Double userBalance;

    public Consumer(FileM fm,String filter) {
        this.fm = fm;
        this.filter = filter;
    }

    public void run(){
        setUserBalance(fm.read(filter));
    }

    public FileM getFm() {
        return fm;
    }

    public void setFm(FileM fm) {
        this.fm = fm;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "fm=" + fm +
                ", filter='" + filter + '\'' +
                ", userBalance=" + userBalance +
                '}';
    }
}
