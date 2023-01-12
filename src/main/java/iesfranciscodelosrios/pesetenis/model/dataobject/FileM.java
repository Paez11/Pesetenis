package iesfranciscodelosrios.pesetenis.model.dataobject;

import java.io.*;
import java.util.Objects;

public class FileM {
    private File file;
    private Client client;
    private Account account;
    private Transition transition;
    private Boolean flag = false;

    public FileM(File file) {
        this.file = file;
    }

    public FileM(File file, Client client, Account account, Transition transition, Boolean flag) {
        this.file = file;
        this.client = client;
        this.account = account;
        this.transition = transition;
        this.flag = flag;
    }

    /**
     * Method to write in a file, it's synchronized with the method read for the model of Producer-Consumer
     * which means that only one thread can write or read at the same time
     * @param client the client who made the transition to write in the file
     * @param account the account of the client who made the transition to write in the file
     * @param transition the transition to write in the file
     */
    public synchronized void write(Client client, Account account, Transition transition){
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
            File dir = new File("C:\\Users\\JSK\\Documents\\Transactions");
            String fileName = client + "_" + account + ".txt";
            fw = new FileWriter(new File(dir, fileName));
            fw.write(client + " " + account + " " + transition);
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
    public synchronized String read(){
        String line = "";
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
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
                ", client=" + client +
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
