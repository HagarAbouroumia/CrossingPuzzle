package game6.MVC;

import game6.Model.Controller;
import game6.Model.StrategyOne;
import game6.Model.StrategyTwo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InstructionsGUI {

    Stage stage;
    Scene scene;
    Controller controller;
    LevelsChoice levelsChoice;
    StrategyOne strategyOne;
    StrategyTwo strategyTwo;
    GameLevelOne gameLevelOne;
    GameLevelTwo gameLevelTwo;
    Button cont = new Button("Continue The Puzzle");
    Button exitBtn = new Button("Exit");
    InstructionsGUI instructionsGUI;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setStrategyOne(StrategyOne strategyOne) {
        this.strategyOne = strategyOne;
    }

    public void setStrategyTwo(StrategyTwo strategyTwo) {
        this.strategyTwo = strategyTwo;
    }

    public void setLevelsChoice(LevelsChoice levelsChoice) {
        this.levelsChoice = levelsChoice;
    }

    public void setGameLevelOne(GameLevelOne gameLevelOne) {
        this.gameLevelOne = gameLevelOne;
    }

    public void setGameLevelTwo(GameLevelTwo gameLevelTwo) {
        this.gameLevelTwo = gameLevelTwo;
    }

    public void prepareSceneOne(Controller strategy) {
        Button backtoLevels = new Button("Back to levels");
        Button toTheGame = new Button("Start the Game ");
        Label textField1 = new Label(strategy.getInstructions()[0]);

        Label textField2 = new Label(strategy.getInstructions()[1]);

        Label textField3 = new Label(strategy.getInstructions()[2]);
        Label textField4 = new Label(strategy.getInstructions()[3]);
        Label textField5 = new Label(strategy.getInstructions()[4]);

        backtoLevels.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                levelsChoice.prepareScene();

                stage.setScene(levelsChoice.getScene());

            }
        }
        );

        exitBtn.setOnAction(e -> Platform.exit());

        cont.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (controller.getiCrosserStrategy() == strategyOne) {

                    stage.setScene(gameLevelOne.getScene());
                } else {
                    stage.setScene(gameLevelTwo.getScene());
                }

            }
        }
        );
        toTheGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                if (controller.getiCrosserStrategy() == strategyOne) {
                    toTheGame.setDisable(true);
                    backtoLevels.setDisable(true);
                    try {
                        gameLevelOne.prepareScene();
                    } catch (IOException ex) {
                        Logger.getLogger(InstructionsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    stage.setScene(gameLevelOne.getScene());
                }
                if (controller.getiCrosserStrategy() == strategyTwo) {
                    toTheGame.setDisable(true);
                    backtoLevels.setDisable(true);
                    try {
                        gameLevelTwo.prepareScene();
                    } catch (IOException ex) {
                        Logger.getLogger(InstructionsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    stage.setScene(gameLevelTwo.getScene());
                }
            }
        }
        );
        VBox vb = new VBox(25);
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(textField1, textField2, textField3, textField4, textField5, backtoLevels, toTheGame, cont, exitBtn);
        scene = new Scene(stack, 1200, 400);

    }

    public Scene getScene() {
        return scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
