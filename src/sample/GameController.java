package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GameController {

    @FXML
    private Pane pane;
    @FXML
    private Label scoreLabel;

    private int score = 0;

    private Cat cat;
    private Fish fish1;
    private Fish fish2;
    private Fish fish3;
    private Dog dog;

    private KeyAction keyAction;
    private AnimationTimer timer;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                fish1 = new Fish(200, 100);
                fish2 = new Fish(100, 500);
                fish3 = new Fish(400, 300);
                dog = new Dog(0,0);
                display();

                pane.setFocusTraversable(true);

                keyAction = new KeyAction(cat);

                timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (!cat.isDead()) {
                            keyAction.action();
                            collisionDetection(fish1);
                            collisionDetection(fish2);
                            collisionDetection(fish3);
                            collisionDetection(dog);
                            dog.walk(cat.getTranslateX(), cat.getTranslateY());
                        }
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
        });
    }

    private void collisionDetection(Fish fish) {
        if (!fish.isDead()) {
            if (cat.getX() > fish.getX() && cat.getX() < fish.getX() + fish.getWIDTH()
                    || cat.getX() + cat.getWIDTH() > fish.getX() && cat.getX() + cat.getWIDTH() < fish.getX() + fish.getWIDTH()) {
                if (cat.getY() > fish.getY() && cat.getY() < fish.getY() + fish.getHEIGHT()
                        || cat.getY() + cat.getHEIGHT() > fish.getY() && cat.getY() + cat.getHEIGHT() < fish.getY() + fish.getHEIGHT()) {
                    fish.dead();
                    scoreLabel.setText("Score: " + ++score);
                }
            }
        }
    }

    private void collisionDetection(Dog dog) {
        if (cat.getX() > dog.getX() && cat.getX() < dog.getX() + dog.getWIDTH()
                || cat.getX() + cat.getWIDTH() > dog.getX() && cat.getX() + cat.getWIDTH() < dog.getX() + dog.getWIDTH()) {
            if (cat.getY() > dog.getY() && cat.getY() < dog.getY() + dog.getHEIGHT()
                    || cat.getY() + cat.getHEIGHT() > dog.getY() && cat.getY() + cat.getHEIGHT() < dog.getY() + dog.getHEIGHT()) {
                cat.dead();
            }
        }
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @FXML
    private void display() {
        cat.draw();
        fish1.draw();
        fish2.draw();
        fish3.draw();
        dog.draw();
        pane.getChildren().addAll(fish1, fish2, fish3, dog, cat);
    }

}
