package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class Fish extends DrawingObject {

    private boolean isDead = false;

    public Fish(double x, double y) {
        super(x, y, 50, 35);
        idleAnimation();
    }

    public void draw() {
        gc.setFill(Color.LIGHTSEAGREEN);
        gc.strokePolygon(new double[]{30, 50, 50}, new double[]{17.5, 7.5, 27.5}, 3);
        gc.fillPolygon(new double[]{30, 50, 50}, new double[]{17.5, 7.5, 27.5}, 3);
        gc.strokeOval(1, 5, 40, 25);
        gc.fillOval(1, 5, 40, 25);
        gc.setFill(Color.GOLD);
        gc.fillArc(6, 20, 30, 10, 190, 160, ArcType.OPEN);
        gc.setFill(Color.YELLOW);
        gc.fillOval(10, 10, 5, 5);
    }

    public void dead() {
        isDead = true;
        deadAnimation();
    }

    private void idleAnimation() {
        RotateTransition rotateAnimation = new RotateTransition(Duration.seconds(0.25),this);
        rotateAnimation.setFromAngle(-20);
        rotateAnimation.setToAngle(20);
        rotateAnimation.setCycleCount(Animation.INDEFINITE);
        rotateAnimation.setAutoReverse(true);
        rotateAnimation.play();

        TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(1), this);
        translateAnimation.setToY(getTranslateY() - 20);
        translateAnimation.setCycleCount(Animation.INDEFINITE);
        translateAnimation.setAutoReverse(true);
        translateAnimation.play();
    }

    private void deadAnimation() {
        FadeTransition fadeAnimation = new FadeTransition(Duration.seconds(0.5), this);
        fadeAnimation.setFromValue(1);
        fadeAnimation.setToValue(0);
        fadeAnimation.play();
    }

    public boolean isDead() {
        return isDead;
    }

}
