package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class StartController {

    @FXML
    private Pane pane;
    @FXML
    private Button startButton;

    private Cat cat;
    private Fish fish;
    private Dog dog;

    @FXML
    public void initialize() {
        cat = new SunnyCat(400, 250);
        fish = new Fish(285, 300);
        dog = new Dog(100, 250);
        display();
    }

    public void handleStartButton(ActionEvent e) {
        Stage stage = (Stage) startButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("selectCatPage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    private void display() {
        cat.draw();
        fish.draw();
        dog.draw();
        pane.getChildren().addAll(cat, fish, dog);
    }

}
