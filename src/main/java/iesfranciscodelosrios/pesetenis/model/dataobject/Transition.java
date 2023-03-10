package iesfranciscodelosrios.pesetenis.model.dataobject;

import iesfranciscodelosrios.pesetenis.utils.Log;

import java.io.File;
import java.util.List;

public class Transition extends Thread {

    private int deposit;
    private int withdraw;
    private String type;

    public Transition(String type) {
        this.type = type;
    }

    public void run(){
        FileM fileM = new FileM(new File("Mock_operations.txt"));
        fileM.setFlag(true);
        Double result = fileM.read(" type: "+type);
        if(type.equals("enter")){
            deposit = result.intValue();
        } else if (type.equals("extract")) {
            withdraw = result.intValue();
        }
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }
}
