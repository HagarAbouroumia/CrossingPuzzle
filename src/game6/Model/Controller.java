package game6.Model;

import game6.ICrosser;
import game6.ICrosserController;
import game6.ICrosserStrategy;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ICrosserController {

    ICrosserStrategy iCrosserStrategy;
    List<ICrosser> crossersOnRightBank​ = new ArrayList<>(4);
    List<ICrosser> crossersOnLeftBank​ = new ArrayList<>(4);
    List<ICrosser> initialCrossers;
    List<ICrosser> crossers;
    int numberofSails = 0;
    boolean fromLeftToRightBank;
    int congratss = 0;

    public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
        this.crossersOnRightBank = crossersOnRightBank;
    }

    public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
        this.crossersOnLeftBank = crossersOnLeftBank;
    }

    // Caretaker caretaker = new Caretaker();
    // Originator originator = new Originator();
//    public void setCaretaker(Caretaker caretaker) {
//        this.caretaker = caretaker;
//    }
//    
//    public void setOriginator(Originator originator) {
//        this.originator = originator;
//    }
    public int getCongratss() {
        return congratss;
    }

    public List<ICrosser> getCrossers() {
        return crossers;
    }

    public void setFromLeftToRightBank(boolean fromLeftToRightBank) {
        this.fromLeftToRightBank = fromLeftToRightBank;
    }

    public void setNumberofSails(int numberofSails) {

        this.numberofSails = numberofSails;
    }

    @Override
    public void newGame(ICrosserStrategy iCrosserStrategy) {
        this.iCrosserStrategy = iCrosserStrategy;
    }

    public ICrosserStrategy getiCrosserStrategy() {
        return iCrosserStrategy;
    }

    @Override
    public void resetGame() {
        crossersOnRightBank.clear();
        crossersOnLeftBank.clear();
        initialCrossers = iCrosserStrategy.getInitialCrossers();
        fromLeftToRightBank = true;
        crossersOnLeftBank = initialCrossers;
        setNumberofSails(0);
        setFromLeftToRightBank(true);

    }

    @Override
    public String[] getInstructions() {
        return iCrosserStrategy.getInstruStrings();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return crossersOnRightBank;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return crossersOnLeftBank;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return fromLeftToRightBank;
    }

    @Override
    public int getNumberofSails() {
        return numberofSails;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

        setFromLeftToRightBank(fromLeftToRightBank);
        System.out.println("checks the position of the boat");
        System.out.println(isBoatOnTheLeftBank());
        int i;
        if (fromLeftToRightBank == true) {
            for (i = 0; i < crossers.size(); i++) {
                crossersOnLeftBank.remove(crossers.get(i));
            }

            for (i = 0; i < crossers.size(); i++) {
                crossersOnRightBank.add(crossers.get(i));
            }
        } else if (fromLeftToRightBank == false) {
            for (i = 0; i < crossers.size(); i++) {
                crossersOnLeftBank.add(crossers.get(i));
            }
            for (i = 0; i < crossers.size(); i++) {
                crossersOnRightBank.remove(crossers.get(i));
            }
        }
        System.out.println(crossersOnLeftBank);
        System.out.println(crossersOnRightBank);

        if (isValid(crossersOnRightBank, crossersOnLeftBank, crossers)) {

            setNumberofSails(numberofSails + 1);
            System.out.println("boat movement is valid");
            if (crossersOnLeftBank.size() == 0) {
                congratss = 1;
            }

            return true;

        } else if (fromLeftToRightBank == true) {
            for (i = 0; i < crossers.size(); i++) {

                crossersOnLeftBank.add(crossers.get(i));

            }
            for (i = 0; i < crossers.size(); i++) {
                crossersOnRightBank.remove(crossers.get(i));
            }
        } else if (fromLeftToRightBank == false) {

            for (i = 0; i < crossers.size(); i++) {
                crossersOnLeftBank.remove(crossers.get(i));

            }
            for (i = 0; i < crossers.size(); i++) {
                crossersOnRightBank.add(crossers.get(i));
            }
        }

        return false;
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank
    ) {
        setNumberofSails(numberofSails + 1);
        iCrosserStrategy.isValid(crossers, crossers, crossers);
    }

    @Override
    public boolean canRdo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<ICrosser>> solveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setiCrosserStrategy(ICrosserStrategy iCrosserStrategy) {
        this.iCrosserStrategy = iCrosserStrategy;
    }

    public String[] getInstruStringsEx() {

        return iCrosserStrategy.getInstruStrings();
    }

    public List<ICrosser> getInitialCrossersEx() {
        initialCrossers = iCrosserStrategy.getInitialCrossers();
        crossersOnLeftBank = initialCrossers;
        return initialCrossers;

    }

    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        return iCrosserStrategy.isValid(rightBankCrossers, leftBankCrossers, boatRiders);
    }

    @Override
    public boolean canMoveToBoat(List<ICrosser> crossers, ICrosser crooser, boolean fromLeftToRightBank) {
        int i;
        if (fromLeftToRightBank == true) {
            for (i = 0; i < crossersOnLeftBank.size(); i++) {
                if ((crooser == crossersOnLeftBank.get(i))) {
                    return true;
                }
            }
        } else if (fromLeftToRightBank == false) {
            for (i = 0; i < crossersOnRightBank.size(); i++) {
                if ((crooser == crossersOnRightBank.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

}
