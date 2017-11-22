package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class StartPageController {

    @FXML
    private Pane pane;

    private SmokeyCat smokeyCat;
    private Fish fish1;
    private Fish fish2;
    private Fish fish3;

    private KeyAction keyAction;
    private AnimationTimer timer;

    @FXML
    public void initialize() {
        smokeyCat = new SmokeyCat(500,500);
        fish1 = new Fish(200, 100);
        fish2 = new Fish(100, 500);
        fish3 = new Fish(400, 300);
        display();

        pane.setFocusTraversable(true);

        keyAction = new KeyAction(smokeyCat);

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

    @FXML
    public void display() {
        pane.getChildren().clear();
        smokeyCat.draw();
        fish1.draw();
        fish2.draw();
        fish3.draw();
        pane.getChildren().addAll(fish1, fish2, fish3, smokeyCat);
    }


}
