package game6.Model;

import game6.ICrosser;
import game6.Model.MementoClass;
import java.util.List;

public class Originator {

    private ICrosser icrossers;

    public void setState(ICrosser icrossers) {
        this.icrossers = icrossers.makeCopy();

    }

    public ICrosser getIcrossers() {
        return icrossers;
    }

    public int getIcrosser() {
        return icrossers.getEatingRank();
    }

    public MementoClass save() {
        return new MementoClass(icrossers);

    }

    public void restore(MementoClass m) {
        icrossers = m.getiCrossers();

    }

}
