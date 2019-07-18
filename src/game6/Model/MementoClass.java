package game6.Model;

import game6.ICrosser;
import java.util.List;

public class MementoClass {

    private ICrosser iCrossers;
  

    public MementoClass(ICrosser iCrossers) {
        this.iCrossers = iCrossers;
 
    }

    public ICrosser getiCrossers() {
        return iCrossers;
    }


 

}
