package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HowToController {

    @FXML
    private Pane pane;
    @FXML
    private Label nameLabel;
    @FXML
    private Label howToLabel;
    @FXML
    private Button backButton;
    @FXML
    private Label wLabel;
    @FXML
    private Label dLabel;
    @FXML
    private Label sLabel;
    @FXML
    private Label aLabel;

    private SmokeyCat cat;

    private KeyAction keyAction;
    private AnimationTimer timer;

    public void initialize() {
        cat = new SmokeyCat(245, 390);
        howToLabel.setText("-Use WASD to move\n-Try to collect all fishs\n-And BEWARE OF DOG!!");
        display();

        pane.setFocusTraversable(true);

        keyAction = new KeyAction(cat);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                keyAction.action();
            }
        };

        timer.start();

        pane.getParent().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()) {
                    case W:
                        keyAction.setMoveUp(true);
                        break;
                    case A:
                        keyAction.setMoveLeft(true);
                        break;
                    case D:
                        keyAction.setMoveRight(true);
                        break;
                    case S:
                        keyAction.setMoveDown(true);
                        break;
                }
            }
        });

        pane.getParent().setOnKeyReleased((event) -> {
            switch(event.getCode()) {
                case W:
                    keyAction.setMoveUp(false);
                    break;
                case A:
                    keyAction.setMoveLeft(false);
                    break;
                case D:
                    keyAction.setMoveRight(false);
                    break;
                case S:
                    keyAction.setMoveDown(false);
                    break;
            }
        });

    }


    public void handleBackButton() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("startPage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void display() {
        pane.getChildren().clear();
        cat.draw();
        pane.getChildren().addAll(nameLabel, wLabel, dLabel, sLabel, aLabel, howToLabel, cat, backButton);
    }

}
