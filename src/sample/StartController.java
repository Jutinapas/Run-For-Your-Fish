package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


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

    @FXML
    public void initialize() {
        cat = new SunnyCat(400, 300);
        fish = new Fish(285, 350);
        dog = new Dog(80, 300);
        bg = new Background();
        display();
    }

    public void handleStartButton(ActionEvent e) {
        Stage stage = (Stage) startButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("selectPage.fxml"));
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
        cat.draw();
        fish.draw();
        dog.draw();
        bg.draw();
        pane.getChildren().addAll(bg, cat, fish, dog, nameLabel, startButton, howToButton, creditButton);
    }

}
