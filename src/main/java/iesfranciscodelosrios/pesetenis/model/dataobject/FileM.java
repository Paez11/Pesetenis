package iesfranciscodelosrios.pesetenis.model.dataobject;

import iesfranciscodelosrios.pesetenis.utils.Log;

import java.io.*;
import java.net.URL;
import java.util.Objects;

public class FileM {
    private File file;
    private Customer Customer;
    private Account account;
    private Transition transition;
    private Boolean flag = false;

    public FileM(){}
    public FileM(File file) {
        this.file = file;
    }

    public FileM(File file, Customer Customer, Account account, Transition transition, Boolean flag) {
        this.file = file;
        this.Customer = Customer;
        this.account = account;
        this.transition = transition;
        this.flag = flag;
    }

    /**
     * Method to write in a file, it's synchronized with the method read for the model of Producer-Consumer
     * which means that only one thread can write or read at the same time
     * @param Customer the Customer who made the transition to write in the file
     * @param account the account of the Customer who made the transition to write in the file
     */
    public synchronized void write(Customer Customer, Account account, String type){
        while (flag){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        flag = true;
        notifyAll();
        FileWriter fw = null;
        try{
            String fileName = Customer.getCustomerName() + "_" + "operations.txt";
            file = new File(fileName);
            fw = new FileWriter(file,true);
            fw.write("Customer: "+ Customer.getCustomerName() + "\n balance: " + account.getBalance() +
                    "\n type: " + type + "\n---------------");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String data){
        FileWriter fw = null;
        try{
            String fileName = "Transitions.txt";
            fw = new FileWriter(fileName);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Method to read a file, it's synchronized with the method write for the model of Producer-Consumer
     * which means that only one thread can write or read at the same time
     * @return the transition read from the file
     */
    public synchronized Double read(){
        String line = "";
        Double balance = 0.0;
        while (!flag){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        flag = false;
        notifyAll();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            while(line!=null) {
                if(line.indexOf(" balance: ")==0){
                    balance = Double.valueOf(line.substring(10,line.length()));
                    /*
                    if (line.matches("\\d+(.\\d+)?")) {
                        balance = Double.valueOf(line);
                    } else {
                        Log.info("Balance not found");
                    }
                     */
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                Log.severe("Could not close the file.");
            }
        }
        return balance;
    }

    /**
     *Getters and Setters
     */

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "FileM{" +
                "file=" + file +
                ", Customer=" + Customer +
                ", account=" + account +
                ", transition=" + transition +
                ", flag=" + flag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileM fileM = (FileM) o;
        return Objects.equals(file, fileM.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file);
    }
}
