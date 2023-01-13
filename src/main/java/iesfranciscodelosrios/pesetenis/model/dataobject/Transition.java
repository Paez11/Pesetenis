package iesfranciscodelosrios.pesetenis.model.dataobject;

import iesfranciscodelosrios.pesetenis.utils.Log;

import java.util.List;

public class Transition extends Thread {
    private List<String> tipes;
    private int deposit;
    private int withdraw;

    public Transition(List<String> tipes) {
        this.tipes = tipes;
    }

    public Transition(List<String> tipes, int deposit, int withdraw) {
        this.tipes = tipes;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }


    public void run(){
        FileM fileM = new FileM();
        for (int i = 0; i < tipes.size(); i++){
            if (tipes.get(i).equals("ingreso")){
                deposit++;
                fileM.write("ingreso"+deposit);
            }else if (tipes.get(i).equals("retiro")){
                withdraw++;
                fileM.write("retiro"+withdraw);
            }else {
                Log.info("nada");
            }
        }
    }

    public List<String> getTipes() {
        return tipes;
    }

    public void setTipes(List<String> tipes) {
        this.tipes = tipes;
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

    @Override
    public String toString() {
        return "Transition{" +
                "tipes=" + tipes +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                '}';
    }
}
