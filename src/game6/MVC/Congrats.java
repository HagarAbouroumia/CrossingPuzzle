package game6.MVC;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Congrats {

    Scene scene;

    Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    Label cong = new Label("Congratulations");

    public void prepareScene() {
        VBox vb = new VBox(25);
        cong.setFont(Font.font("Cambria", 32));
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(cong);
        scene = new Scene(stack, 1200, 400);
    }

}
