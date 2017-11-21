package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class StartPageController {

    @FXML
    private Pane pane;

    private GingerCat gingerCat;
    private SmokeyCat smokeyCat;
    private SunnyCat sunnyCat;

    private KeyAction keyAction;
    private AnimationTimer timer;

    @FXML
    public void initialize() {
        gingerCat = new GingerCat(300, 300);
        smokeyCat = new SmokeyCat(100,300);
        sunnyCat = new SunnyCat(0,100);
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
        gingerCat.draw();
        smokeyCat.draw();
        sunnyCat.draw();
        pane.getChildren().addAll(gingerCat, smokeyCat ,sunnyCat);
    }


}
