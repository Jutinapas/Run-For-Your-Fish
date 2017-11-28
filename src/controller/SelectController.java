package controller;

import model.Background;
import model.GingerCat;
import model.SmokeyCat;
import model.SunnyCat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class SelectController {


    @FXML
    private Pane pane;
    @FXML
    private Button gingerButton;
    @FXML
    private Button sunnyButton;
    @FXML
    private Button smokeyButton;
    @FXML
    private Button backButton;
    @FXML
    private Label label;

    private GingerCat ginger;
    private SunnyCat sunny;
    private SmokeyCat smokey;
    private Background bg;

    @FXML
    public void initialize() {
        ginger = new GingerCat(70, 300);
        sunny = new SunnyCat(250, 300);
        smokey = new SmokeyCat(420, 300);
        bg = new Background();
        display();
    }

    public void handleGingerButton(ActionEvent e) {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gamePage.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gamePage.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gamePage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            GameController controller = loader.getController();
            controller.setCat(new SmokeyCat(500, 500));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void handleBackButton() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/startPage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private void display() {
        pane.getChildren().clear();
        ginger.draw();
        sunny.draw();
        smokey.draw();
        bg.draw();
        pane.getChildren().addAll(bg, ginger, sunny, smokey, label, gingerButton, sunnyButton, smokeyButton, backButton);
    }

}
