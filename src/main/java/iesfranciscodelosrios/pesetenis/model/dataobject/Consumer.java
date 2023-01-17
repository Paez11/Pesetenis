package iesfranciscodelosrios.pesetenis.model.dataobject;

public class Consumer extends Thread {
    private FileM fm;

    public Consumer(FileM fm) {
        this.fm = fm;
    }

    public void run(){
        fm.read();
    }
}
