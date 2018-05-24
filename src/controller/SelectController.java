package controller;

import javafx.scene.control.ComboBox;
import model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class SelectController {


    @FXML
    private Pane pane;
    @FXML
    private ComboBox<Difficulty> comboBox;
    @FXML
    private Button gingerButton;
    @FXML
    private Button sunnyButton;
    @FXML
    private Button smokeyButton;
    @FXML
    private Button backButton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;

    private Cat ginger, sunny, smokey;
    private Background bg;

    private ArrayList<DrawingObject> drawingList = new ArrayList<>();

    @FXML
    public void initialize() {
        comboBox.setPromptText("Easy");
        comboBox.getItems().addAll(
                Difficulty.Easy,
                Difficulty.Normal,
                Difficulty.Hard
        );
        ginger = new Cat(CatType.Ginger,70, 300);
        drawingList.add(ginger);
        sunny = new Cat(CatType.Sunny,250, 300);
        drawingList.add(sunny);
        smokey = new Cat(CatType.Smokey,420, 300);
        drawingList.add(smokey);
        bg = new Background();
        drawingList.add(bg);
        display();
    }

    private Difficulty getDifficulty() {
        if (comboBox.getValue() == null) {
            return Difficulty.Easy;
        } else {
            return comboBox.getValue();
        }
    }

    public void handleGingerButton(ActionEvent e) {
        loadGameScene(new Cat(CatType.Ginger,500, 500), getDifficulty());
    }

    public void handleSunnyButton(ActionEvent e) {
        loadGameScene(new Cat(CatType.Sunny,500, 500), getDifficulty());
    }

    public void handleSmokeyButton(ActionEvent e) {
        loadGameScene(new Cat(CatType.Smokey, 500, 500), getDifficulty());
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

    private void loadGameScene(Cat cat, Difficulty difficulty) {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gamePage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            GameController controller = loader.getController();
            controller.setCat(cat);
            controller.setDifficulty(difficulty);
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private void display() {
        pane.getChildren().clear();
        for (DrawingObject object: drawingList) {
            object.draw();
        }
        pane.getChildren().addAll(bg, ginger, sunny, smokey, label1, label2, gingerButton, sunnyButton, smokeyButton, backButton, comboBox);
    }

}
