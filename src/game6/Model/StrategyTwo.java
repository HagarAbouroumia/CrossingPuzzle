package game6.Model;

import game6.Farmer;
import game6.Herbivorous;
import game6.ICrosser;
import game6.ICrosserStrategy;
import game6.Model.StrategyOne;
import game6.MVC.GameLevelTwo;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;

public class StrategyTwo implements ICrosserStrategy {

    private static StrategyTwo instance;
    StrategyOne strategyOne;
    List<ICrosser> initialCrossers = new ArrayList<>(4);
    GameLevelTwo gameLevelTwo;
    Label one = new Label();
    Label f1 = new Label();
    Label f2 = new Label();
    Label f3 = new Label();
    Label f4 = new Label();
    Label f5 = new Label();
    Controller controller;

    public Label getF1() {
        return f1;
    }

    public Label getF2() {
        return f2;
    }

    public Label getF3() {
        return f3;
    }

    public Label getF4() {
        return f4;
    }

    public Label getF5() {
        return f5;
    }

    public Label getOne() {
        return one;
    }

    public void setGameLevelTwo(GameLevelTwo gameLevelTwo) {
        this.gameLevelTwo = gameLevelTwo;
    }

    public static StrategyTwo getInstance() {
        if (instance == null) {
            instance = new StrategyTwo();
        }
        return instance;
    }
    Farmer farmerOne = new Farmer();
    Farmer farmerTwo = new Farmer();
    Farmer farmerThree = new Farmer();
    Farmer farmerFour = new Farmer();
    Herbivorous goat = new Herbivorous();

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        double weight = 0, count = 0;
        int i;
        for (i = 0; i < boatRiders.size(); i++) {
            if (boatRiders.get(i).getEatingRank() == 4) {

                count++;
            }
        }
        if (count == 0) {
            one.setText("The Farmer Should Steer the boat");
            return false;
        }
        for (i = 0; i < boatRiders.size(); i++) {
            weight = weight + boatRiders.get(i).getWeight();
        }
        if (weight > 100) {
            one.setText("OVERWEIGHT");
            return false;
        }

        return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {

        f1.setText(String.valueOf(farmerOne.getWeight() + " kg"));
        f2.setText(String.valueOf(farmerTwo.getWeight() + " kg"));
        f3.setText(String.valueOf(farmerThree.getWeight() + " kg"));
        f4.setText(String.valueOf(farmerFour.getWeight() + " kg"));
        f5.setText(String.valueOf(goat.getWeight() + " kg"));

        initialCrossers.add(0, farmerOne);
        initialCrossers.add(1, farmerTwo);
        initialCrossers.add(2, farmerThree);
        initialCrossers.add(3, farmerFour);
        initialCrossers.add(4, goat);
        gameLevelTwo.setFarmerOne(farmerOne);
        gameLevelTwo.setFarmerTwo(farmerTwo);
        gameLevelTwo.setFarmerThree(farmerThree);
        gameLevelTwo.setFarmerThree(farmerThree);
        gameLevelTwo.setFarmerFour(farmerFour);
        gameLevelTwo.setGoat(goat);

        return initialCrossers;
    }

    @Override
    public String[] getInstruStrings() {
        farmerOne.setWeight(100);
        farmerTwo.setWeight(80);
        farmerThree.setWeight(60);
        farmerFour.setWeight(40);
        String[] instructions = new String[5];
        instructions[0] = "Four farmers and their animal need to cross a river in a small boat. The weights of the farmers  are 90 kg, 80 kg,60 kg and 40 kg respectively, and the weight of the animal is 20 kg.";
        instructions[1] = "Rules:";
        instructions[2] = "1.​The boat cannot bear a load heavier than 100 kg.";
        instructions[3] = "2.​All farmers can raft, while the animal cannot.";
        instructions[4] = "How can they all get to the other side with their animal?";
        return instructions;

    }

}
