package game6;

import java.util.List;

public interface ICrosserStrategy {

    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders);

    public List<ICrosser> getInitialCrossers();

    public String[] getInstruStrings();
    


}
