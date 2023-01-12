package iesfranciscodelosrios.pesetenis.model.dataobject;

import java.util.List;

public class Transition {
    private List<String> tipes;

    public Transition(List<String> tipes) {
        this.tipes = tipes;
    }

    public List<String> getTipes() {
        return tipes;
    }

    public void setTipes(List<String> tipes) {
        this.tipes = tipes;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "tipes=" + tipes +
                '}';
    }
}
