package model;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class Cat extends DrawingObject implements OnConllisionListener {

    private CatType type;
    private final double SPEED = 2;
    private boolean isFlip = false;
    private boolean isDead = false;

    public Cat(CatType type, double x, double y) {
        super(x, y, 100, 80);
        this.type = type;
        idleAnimation();
    }

    public void draw() {
        if (type == CatType.Ginger) {
            drawGingerCat();
        } else if (type == CatType.Sunny) {
            drawSunnyCat();
        } else if (type == CatType.Smokey) {
            drawSmokeyCat();
        }
    }

    private void drawGingerCat() {
        drawTail(Color.WHITE);
        drawBody(Color.SANDYBROWN);
        drawHead(Color.WHITE, Color.WHITE, Color.SANDYBROWN);
        drawFace(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.fillOval(20.5, 30, 24,12);
        gc.strokeArc(25,30,7,7, 170, 180, ArcType.OPEN);
        gc.strokeArc(32,30,7,7, 180, 190, ArcType.OPEN);
        drawLegs(Color.WHITE);
    }

    private void drawSunnyCat() {
        drawTail(Color.WHITE);
        drawBody(Color.WHITE);
        gc.setFill(Color.GOLD);
        gc.fillOval(40,20, 40, 20);
        gc.setFill(Color.GRAY);
        gc.fillOval(65, 32.5, 25, 20);
        drawHead(Color.GRAY, Color.GOLD, Color.WHITE);
        gc.setFill(Color.GOLD);
        gc.fillOval(35,10, 20, 25);
        drawFace(Color.BLACK);
        drawLegs(Color.WHITE);
    }

    private void drawSmokeyCat() {
        drawTail(Color.GRAY);
        drawBody(Color.GRAY);
        drawHead(Color.GRAY, Color.GRAY, Color.GRAY);
        drawFace(Color.YELLOW);
        drawLegs(Color.GRAY);
    }

    private void drawTail(Color c1) {
        gc.setFill(c1);
        gc.rotate(15);
        gc.strokeArc(85, -20, 10, 40, -150, -270, ArcType.OPEN);
        gc.fillArc(85, -20, 10, 40, -150, -270, ArcType.OPEN);
        gc.rotate(-15);
    }

    private void drawBody(Color c1) {
        gc.setFill(c1);
        gc.strokeOval(20, 20, 70, 45);
        gc.fillOval(20, 20, 70 ,45);
    }

    private void drawHead(Color c1, Color c2, Color c3) {
        gc.rotate(-15);
        gc.setFill(c1);
        gc.strokePolygon(new double[]{10,15,20}, new double[]{20,5,20}, 3);
        gc.fillPolygon(new double[]{10,15,20}, new double[]{20,5,20}, 3);
        gc.rotate(30);
        gc.setFill(c2);
        gc.strokePolygon(new double[]{45,50,55}, new double[]{0,-15,0}, 3);
        gc.fillPolygon(new double[]{45,50,55}, new double[]{0,-15,0}, 3);
        gc.rotate(-15);
        gc.setFill(c3);
        gc.strokeOval(10,10, 50, 40);
        gc.fillOval(10,10, 50, 40);
    }

    private void drawFace(Color c1) {
        gc.setFill(c1);
        gc.fillOval(20, 20, 7, 7);
        gc.fillOval(40, 20, 7, 7);
        gc.setFill(Color.BLACK);
        gc.strokeArc(25,30,7,7, 170, 180, ArcType.OPEN);
        gc.strokeArc(32,30,7,7, 180, 190, ArcType.OPEN);
    }

    private void drawLegs(Color c1) {
        gc.setFill(c1);
        gc.strokeArc(23, 35, 12, 40, 170, 180, ArcType.OPEN);
        gc.fillArc(23, 35, 12, 40, 170, 180, ArcType.OPEN);
        gc.rotate(15);
        gc.strokeArc(55, 23, 12, 40, 190, 180, ArcType.OPEN);
        gc.fillArc(55, 23, 12, 40, 190, 180, ArcType.OPEN);
        gc.rotate(-15);
        gc.strokeArc(65, 55, 12, 17, 170, 230, ArcType.CHORD);
        gc.fillArc(65, 55, 12, 17, 170, 230, ArcType.CHORD);
        gc.rotate(15);
        gc.strokeArc(85, 13, 12, 40, 200, 180, ArcType.OPEN);
        gc.fillArc(85, 13, 12, 40, 200, 180, ArcType.OPEN);
        gc.rotate(-15);
    }

    public void grow() { growAnimation(); }

    private void idleAnimation() {
        ScaleTransition scaleAnimation = new ScaleTransition(Duration.seconds(0.5), this);
        scaleAnimation.setToY(1.1);
        scaleAnimation.setAutoReverse(true);
        scaleAnimation.setCycleCount(Animation.INDEFINITE);
        scaleAnimation.play();
    }

    private void deadAnimation() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), this);
        if (!isFlip) {
            rotateTransition.setByAngle(90);
        } else {
            rotateTransition.setByAngle(-90);
        }
        rotateTransition.play();
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), this);
        fadeTransition.setDelay(Duration.seconds(1));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }

    private void growAnimation() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), this);
        scaleTransition.setFromX(1);
        scaleTransition.setToX(2);
        scaleTransition.setFromY(1);
        scaleTransition.setToY(2);
        scaleTransition.play();
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), this);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setDelay(Duration.seconds(1));
        fadeTransition.play();
    }

    public void moveRight() {
        if (getTranslateX() + getWIDTH() + SPEED < 600)
            setTranslateX(getTranslateX() + SPEED);
        if (isFlip == false) {
            filpCanvas();
            isFlip = true;
        }
    }

    public void moveLeft() {
        if (getTranslateX() - SPEED > 0)
            setTranslateX(getTranslateX() - SPEED);
        if (isFlip == true) {
            filpCanvas();
            isFlip = false;
        }
    }

    public void moveUp() {
        if (getTranslateY() - SPEED > 0) setTranslateY(getTranslateY() - SPEED);
    }

    public void moveDown() {
        if (getTranslateY() + getHEIGHT() + SPEED < 600)
            setTranslateY(getTranslateY() + SPEED);
    }

    public double getSPEED() {
        return SPEED;
    }

    public boolean isDead() {
        return isDead;
    }

    @Override
    public void onCollisionEnter(DrawingObject object) {
        if (object instanceof Dog) {
            isDead = true;
            deadAnimation();
        }
    }

}
