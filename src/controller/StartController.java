package controller;

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


public class StartController {

    @FXML
    private Pane pane;
    @FXML
    private Label nameLabel;
    @FXML
    private Button startButton;
    @FXML
    private Button howToButton;
    @FXML
    private Button creditButton;

    private Cat cat;
    private Fish fish;
    private Dog dog;
    private Background bg;
    private ArrayList<DrawingObject> drawingList = new ArrayList<>();

    @FXML
    public void initialize() {
        cat = new Cat(CatType.Sunny,385, 300);
        drawingList.add(cat);
        fish = new Fish(285, 350, false);
        drawingList.add(fish);
        dog = new Dog(100, 300);
        drawingList.add(dog);
        bg = new Background();
        drawingList.add(bg);
        display();
    }

    public void handleStartButton(ActionEvent e) {
        changeScene("/view/selectPage.fxml");
    }

    public void handleHowToButton(ActionEvent e) {
        changeScene("/view/howToPage.fxml");
    }

    public void handleCreditButton(ActionEvent e) {
        changeScene("/view/creditPage.fxml");
    }

    private void changeScene(String scene) {
        Stage stage = (Stage) creditButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
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
        for (DrawingObject object: drawingList) {
            object.draw();
        }
        pane.getChildren().addAll(bg, cat, fish, dog, nameLabel, startButton, howToButton, creditButton);
    }

}
