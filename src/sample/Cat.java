package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public abstract class Cat extends DrawingObject {

    private final double SPEED = 2;
    private final double WIDTH = 100;
    private final double HEIGHT = 80;
    private boolean isFlip = false;

    public Cat(double x, double y) {
        super(x, y, 100, 80);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
    }

    protected abstract void draw();

    protected void drawTail(Color c1) {
        gc.setFill(c1);
        gc.rotate(15);
        gc.strokeArc(85, -20, 10, 40, -150, -270, ArcType.OPEN);
        gc.fillArc(85, -20, 10, 40, -150, -270, ArcType.OPEN);
        gc.rotate(-15);
    }

    protected void drawBody(Color c1) {
        gc.setFill(c1);
        gc.strokeOval(20, 20, 70, 45);
        gc.fillOval(20, 20, 70 ,45);
    }

    protected void drawHead(Color c1, Color c2, Color c3) {
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

    protected void drawFace(Color c1) {
        gc.setFill(c1);
        gc.fillOval(20, 20, 7, 7);
        gc.fillOval(40, 20, 7, 7);
        gc.setFill(Color.BLACK);
        gc.strokeArc(25,30,7,7, 170, 180, ArcType.OPEN);
        gc.strokeArc(32,30,7,7, 180, 190, ArcType.OPEN);
    }

    protected void drawLegs(Color c1) {
        gc.setFill(c1);
        //foreleg
        gc.strokeArc(23, 35, 12, 40, 170, 180, ArcType.OPEN);
        gc.fillArc(23, 35, 12, 40, 170, 180, ArcType.OPEN);
        gc.rotate(15);
        gc.strokeArc(55, 23, 12, 40, 190, 180, ArcType.OPEN);
        gc.fillArc(55, 23, 12, 40, 190, 180, ArcType.OPEN);
        gc.rotate(-15);
        //hindleg
        gc.strokeArc(65, 55, 12, 17, 170, 230, ArcType.CHORD);
        gc.fillArc(65, 55, 12, 17, 170, 230, ArcType.CHORD);
        gc.rotate(15);
        gc.strokeArc(85, 13, 12, 40, 200, 180, ArcType.OPEN);
        gc.fillArc(85, 13, 12, 40, 200, 180, ArcType.OPEN);
        gc.rotate(-15);
    }

    public void moveRight() {
        if (getTranslateX() + WIDTH + SPEED < 600)
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
        if (getTranslateY() + HEIGHT + SPEED < 600)
            setTranslateY(getTranslateY() + SPEED);
    }

}
