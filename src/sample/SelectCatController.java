package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class SelectCatController {


    @FXML
    private Pane pane;
    @FXML
    private Button gingerButton;
    @FXML
    private Button sunnyButton;
    @FXML
    private Button smokeyButton;

    private GingerCat ginger;
    private SunnyCat sunny;
    private SmokeyCat smokey;

    @FXML
    public void initialize() {
        ginger = new GingerCat(70, 300);
        sunny = new SunnyCat(250, 300);
        smokey = new SmokeyCat(420, 300);
        display();
    }

    public void handleGingerButton(ActionEvent e) {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gamePage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            GameController controller = loader.getController();
            controller.setCat(new GingerCat(500, 500));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void handleSunnyButton(ActionEvent e) {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gamePage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            GameController controller = loader.getController();
            controller.setCat(new SunnyCat(500, 500));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void handleSmokeyButton(ActionEvent e) {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gamePage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            GameController controller = loader.getController();
            controller.setCat(new SmokeyCat(500, 500));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private void display() {
        ginger.draw();
        sunny.draw();
        smokey.draw();
        pane.getChildren().addAll(ginger, sunny, smokey);
    }

}
