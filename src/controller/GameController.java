package controller;

import javafx.scene.Node;
import model.*;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameController {

    @FXML
    private Pane pane;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label winningLabel;
    @FXML
    private Label gameOverLabel;
    @FXML
    private Button restartButton;

    private int score = 0;
    private Difficulty difficulty;

    private Cat cat;
    private Fish fish1;
    private Fish fish2;
    private Fish fish3;
    private Fish fish4;
    private Fish fish5;
    private Dog dog;
    private Background bg;
    private ArrayList<DrawingObject> drawingList = new ArrayList<>();
    private ArrayList<Integer> pos = new ArrayList<>();

    private boolean gameEnd = false;

    private KeyAction keyAction;
    private AnimationTimer timer;
    private Random random = new Random();

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                drawingList.add(cat);
                if (difficulty == Difficulty.Easy) dog = new Dog(0, 0);
                else if (difficulty == Difficulty.Normal) dog = new Dog(0.75, 0, 0);
                else if (difficulty == Difficulty.Hard) dog = new Dog(1, 0, 0);
                drawingList.add(dog);
                fish1 = new Fish(getRandomPos(), getRandomPos(), random.nextBoolean());
                drawingList.add(fish1);
                fish2 = new Fish(getRandomPos(), getRandomPos(), random.nextBoolean());
                drawingList.add(fish2);
                fish3 = new Fish(getRandomPos(), getRandomPos(), random.nextBoolean());
                drawingList.add(fish3);
                fish4 = new Fish(getRandomPos(), getRandomPos(), random.nextBoolean());
                drawingList.add(fish4);
                fish5 = new Fish(getRandomPos(), getRandomPos(), random.nextBoolean());
                drawingList.add(fish5);
                bg = new Background();
                drawingList.add(bg);
                display();

                pane.setFocusTraversable(true);

                keyAction = new KeyAction(cat);

                timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (!gameEnd) {
                            keyAction.action();
                            if ((!fish1.isDead() && onCollisionDetect(cat, fish1)) ||
                                    (!fish2.isDead() && onCollisionDetect(cat, fish2)) ||
                                    (!fish3.isDead() && onCollisionDetect(cat, fish3)) ||
                                    (!fish4.isDead() && onCollisionDetect(cat, fish4)) ||
                                    (!fish5.isDead() && onCollisionDetect(cat, fish5))) {
                                    scoreLabel.setText("Score: " + ++score);
                            }
                            onCollisionDetect(dog, cat);
                            checkEndGame();
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

    private int getRandomPos() {
        int x = random.nextInt(450 ) + random.nextInt(25) + random.nextInt(25);
        while (pos.contains(x)) {
            x = random.nextInt(450) + random.nextInt(25) + random.nextInt(25);
        }
        pos.add(x);
        return x;
    }

    private boolean onCollisionDetect(DrawingObject object1, OnConllisionListener object2) {
        if (object1.collisionDetection((DrawingObject) object2)) {
            object2.onCollisionEnter(object1);
            return true;
        }
        return false;
    }

    private void checkEndGame() {
        if (score == 5) {
            gameEnd = true;
            cat.grow();
            labelPopUp(winningLabel);
        } else if (cat.isDead()) {
            gameEnd = true;
            labelPopUp(gameOverLabel);
        }
    }

    private void labelPopUp(Label label) {
        pane.getChildren().clear();
        restartButton.setDisable(false);
        pane.getChildren().addAll(bg, label, scoreLabel, cat, restartButton);
        popUpAnimation(label);
        popUpAnimation(restartButton);
    }

    private void popUpAnimation(Node node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), node);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), node);
        scaleTransition.setFromX(0);
        scaleTransition.setToX(1);
        scaleTransition.setFromY(0);
        scaleTransition.setToY(1);
        fadeTransition.play();
        scaleTransition.play();
    }

    public void handleRestartButton() {
        Stage stage = (Stage) restartButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/selectPage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    @FXML
    private void display() {
        pane.getChildren().clear();
        for (DrawingObject object: drawingList) {
            object.draw();
        }
        pane.getChildren().addAll(bg, fish1, fish2, fish3, fish4, fish5, dog, cat, scoreLabel);
    }

}
