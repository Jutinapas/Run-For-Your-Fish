package sample;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class Dog extends DrawingObject {

    private boolean isFlip = false;
    private final double SPEED = 0.5;

    public Dog(double x, double y) {
        super(x, y, 120, 80);
        filpCanvas();
        idleAnimation();
    }

    public void draw() {
        drawBody();
        drawHead();
    }

    private void drawBody() {
        gc.setFill(Color.NAVAJOWHITE);
        gc.strokeOval(95, 15, 20, 20);
        gc.fillOval(95, 15, 20, 20);
        gc.strokeArc(70, 7, 20, 70, 180, 180, ArcType.OPEN );
        gc.fillArc(70, 7, 20, 70, 180, 180, ArcType.OPEN );
        gc.fillOval(20, 10, 90, 50);
        gc.strokeOval(20, 10, 90, 50);
        gc.rotate(10);
        gc.fillArc(25, 0, 20, 70, 180, 180, ArcType.OPEN );
        gc.strokeArc(25, 0, 20, 70, 180, 180, ArcType.OPEN );
        gc.fillArc(45, 0, 20, 70, 180, 180, ArcType.OPEN );
        gc.strokeArc(45, 0, 20, 70, 180, 180, ArcType.OPEN );
        gc.rotate(-15);
        gc.strokeArc(85, 15, 20, 70, 180, 180, ArcType.OPEN );
        gc.fillArc(85, 15, 20, 70, 180, 180, ArcType.OPEN );
        gc.rotate(5);
    }

    private void drawHead() {
        gc.setFill(Color.NAVAJOWHITE);
        gc.rotate(-10);
        gc.strokeOval(40, 20, 15, 30);
        gc.fillOval(40, 20, 15, 30);
        gc.rotate(20);
        gc.strokeOval(5, 5, 15, 30);
        gc.fillOval(5, 5, 15, 30);
        gc.strokeArc(10, -5, 48, 60, 140, 270, ArcType.CHORD);
        gc.fillArc(10, -5, 48, 60, 140, 270, ArcType.CHORD);
        gc.rotate(-10);
        gc.setFill(Color.BLACK);
        gc.fillOval(18, 20, 3,8);
        gc.fillOval(25, 20, 3,8);
        gc.rotate(5);
        gc.fillPolygon(new double[]{17, 25, 33}, new double[]{32, 40, 32}, 3);
        gc.strokeArc(18,37,7,7, 170, 180, ArcType.OPEN);
        gc.strokeArc(25,37,7,7, 180, 190, ArcType.OPEN);
    }

    public void walk(double x, double y) {
        if (x > getTranslateX()) {
            if (isFlip) {
                filpCanvas();
                isFlip = false;
            }
            setTranslateX(getTranslateX() + SPEED);
        } if (x < getTranslateX()) {
            if (!isFlip) {
                filpCanvas();
                isFlip = true;
            }
            setTranslateX(getTranslateX() - SPEED);
        } if (y > getTranslateY()) {
            setTranslateY(getTranslateY() + SPEED);
        } if (y < getTranslateY()) {
            setTranslateY(getTranslateY() - SPEED);
        }
    }

    private void idleAnimation() {
        ScaleTransition scaleAnimation = new ScaleTransition(Duration.seconds(0.5), this);
        scaleAnimation.setToY(1.1);
        scaleAnimation.setAutoReverse(true);
        scaleAnimation.setCycleCount(Animation.INDEFINITE);
        scaleAnimation.play();
    }

}
