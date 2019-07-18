package game6.Model;

import game6.Carnivorous;
import game6.Farmer;
import game6.Herbivorous;
import game6.ICrosser;
import game6.ICrosserStrategy;
import game6.MVC.GameLevelOne;
import game6.Plant;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;

public class StrategyOne implements ICrosserStrategy {

    private static StrategyOne instance;
    StrategyOne strategyOne;
    List<ICrosser> initialCrossers = new ArrayList<>(4);
    GameLevelOne gameLevelOne;
    Label one = new Label();
    Controller controller;

    public Label getOne() {
        return one;
    }

    public void setGameLevelOne(GameLevelOne gameLevelOne) {
        this.gameLevelOne = gameLevelOne;
    }

    public static StrategyOne getInstance() {
        if (instance == null) {
            instance = new StrategyOne();
        }
        return instance;
    }
    Farmer farmerOne = new Farmer();
    Herbivorous goat = new Herbivorous();
    Carnivorous lion = new Carnivorous();
    Plant apple = new Plant();

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, i;
        for (i = 0; i < boatRiders.size(); i++) {
            if (boatRiders.get(i).getEatingRank() == 4) {

                count5++;
            }
        }
        if (count5 == 0) {
            one.setText("The Farmer Should Steer the boat");
            return false;
        }

        if (rightBankCrossers.isEmpty() == false) {
            if (rightBankCrossers.size() == 1) {
                return true;
            }
            for (i = 0; i < rightBankCrossers.size(); i++) {
                if (rightBankCrossers.get(i).getEatingRank() == 1 || rightBankCrossers.get(i).getEatingRank() == 2) {
                    count1++;
                }
                if (rightBankCrossers.get(i).getEatingRank() == 2 || rightBankCrossers.get(i).getEatingRank() == 3) {
                    count2++;
                }
            }
            if (rightBankCrossers.size() == count1 || rightBankCrossers.size() == count2) {
                if (rightBankCrossers.size() == count1) {
                    one.setText("The goat will eat the apple");
                }
                if (rightBankCrossers.size() == count2) {
                    one.setText("The lion will eat the goat");
                }
                return false;
            }

        }
        if (leftBankCrossers.isEmpty() == false) {
            if (leftBankCrossers.size() == 1) {
                return true;
            }
            for (i = 0; i < leftBankCrossers.size(); i++) {
                if (leftBankCrossers.get(i).getEatingRank() == 1 || leftBankCrossers.get(i).getEatingRank() == 2) {
                    count3++;
                }
                if (leftBankCrossers.get(i).getEatingRank() == 2 || leftBankCrossers.get(i).getEatingRank() == 3) {
                    count4++;
                }
            }
            if (leftBankCrossers.size() == count3 || leftBankCrossers.size() == count4) {
                if (rightBankCrossers.size() == count3) {
                    one.setText("The goat will eat the apple");
                }
                if (rightBankCrossers.size() == count4) {
                    one.setText("The lion will eat the goat");
                }
                return false;
            }
        }

        return true;

    }

    @Override
    public List<ICrosser> getInitialCrossers() {
//        int x = initialCrossers.size();
//        System.out.println(x);
        initialCrossers.add(0, farmerOne);
        initialCrossers.add(1, goat);
        initialCrossers.add(2, lion);
        initialCrossers.add(3, apple);
        gameLevelOne.setApple(apple);
        gameLevelOne.setFarmerOne(farmerOne);
        gameLevelOne.setGoat(goat);
        gameLevelOne.setLion(lion);
        //  controller.setCrossersOnLeftBank(initialCrossers);

        return initialCrossers;
    }

    @Override
    public String[] getInstruStrings() {

        String[] instructions = new String[5];
        instructions[0] = "A farmer wants to cross a river and take with him a carnivorous, a herbivorous and plant.";
        instructions[1] = "Rules:";
        instructions[2] = "1.​The farmer is the only one who can sail the boat. He can only take one passenger, in addition to himself.  ";
        instructions[3] = "2.​You can not leave any two crossers on the same bank if they can harm(eat) each other";
        instructions[4] = "How can the farmer get across the river with all the 2 animals and the plant without any losses? ";
        return instructions;
    }

}
