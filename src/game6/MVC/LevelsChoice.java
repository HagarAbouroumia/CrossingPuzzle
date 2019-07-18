package game6.MVC;

import game6.Model.Controller;
import game6.MVC.InstructionsGUI;
import game6.Model.StrategyOne;
import game6.Model.StrategyTwo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class LevelsChoice {

    Scene scene;
    Stage stage;
    InstructionsGUI instructionsGUI;
    Controller controller;

    StrategyOne strategyOne;
    StrategyTwo strategyTwo;
    
   

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setStrategyOne(StrategyOne strategyOne) {
        this.strategyOne = strategyOne;
    }

    public void setStrategyTwo(StrategyTwo strategyTwo) {
        this.strategyTwo = strategyTwo;
    }

    public void prepareScene() {
     

        Button one = new Button("Level One");
        Button two = new Button("Level Two");

        one.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.newGame(strategyOne);
                instructionsGUI.prepareSceneOne(controller);
                stage.setScene(instructionsGUI.getScene());
            }
        }
        );
        two.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.newGame(strategyTwo);
                instructionsGUI.prepareSceneOne(controller);
                stage.setScene(instructionsGUI.getScene());
            }
        }
        );

        VBox vb = new VBox(25);
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(one, two);
        scene = new Scene(stack, 600, 400);

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setInstructionsGUI(InstructionsGUI instructionsGUI) {
        this.instructionsGUI = instructionsGUI;
    }

}
