package game6.MVC;

import game6.Model.Caretaker;
import game6.Model.Controller;
import game6.MVC.GameLevelTwo;
import game6.MVC.GameLevelOne;
import game6.MVC.InstructionsGUI;
import game6.MVC.Congrats;
import game6.Model.Originator;
import game6.Model.StrategyOne;
import game6.Model.StrategyTwo;
import game6.Solve;
import game6.Solver;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        LevelsChoice levelsChoice = new LevelsChoice();
        InstructionsGUI instructionsGUI = new InstructionsGUI();
        Controller controller = new Controller();
        GameLevelOne gameLevelOne = new GameLevelOne();
        GameLevelTwo gameLevelTwo = new GameLevelTwo();
        Congrats congrats = new Congrats();
        StrategyOne strategyOne = StrategyOne.getInstance();
        StrategyTwo strategyTwo = StrategyTwo.getInstance();
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        gameLevelOne.setCaretaker(caretaker);
        gameLevelOne.setOriginator(originator);
        Solve sove = new Solve();

        levelsChoice.setStage(primaryStage);
        instructionsGUI.setStage(primaryStage);
        gameLevelOne.setStage(primaryStage);
        gameLevelTwo.setStage(primaryStage);

        levelsChoice.prepareScene();

        strategyOne.setGameLevelOne(gameLevelOne);
        strategyTwo.setGameLevelTwo(gameLevelTwo);
        gameLevelTwo.setStrategyTwo(strategyTwo);

        gameLevelOne.setController(controller);
        gameLevelOne.setStrategyOne(strategyOne);
        gameLevelOne.setInstructionsGUI(instructionsGUI);
        gameLevelOne.setGameLevelOne(gameLevelOne);
        gameLevelOne.setCongrats(congrats);

        gameLevelTwo.setController(controller);
        gameLevelTwo.setStrategyTwo(strategyTwo);
        gameLevelTwo.setInstructionsGUI(instructionsGUI);
        gameLevelTwo.setGameLevelTwo(gameLevelTwo);
        gameLevelTwo.setController(controller);
        gameLevelTwo.setCongrats(congrats);

        levelsChoice.setInstructionsGUI(instructionsGUI);

        levelsChoice.setController(controller);
        levelsChoice.setStrategyOne(strategyOne);
        levelsChoice.setStrategyTwo(strategyTwo);

        instructionsGUI.setController(controller);
        instructionsGUI.setLevelsChoice(levelsChoice);
        instructionsGUI.setGameLevelOne(gameLevelOne);
        instructionsGUI.setGameLevelTwo(gameLevelTwo);
        instructionsGUI.setStrategyOne(strategyOne);
        instructionsGUI.setStrategyTwo(strategyTwo);

        primaryStage.setTitle("Cross Puzzle Game");
        primaryStage.setScene(levelsChoice.getScene());
        primaryStage.show();
    }

}
