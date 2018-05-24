package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class DrawingObject extends Canvas {

    private final double WIDTH;
    private final double HEIGHT;

    protected GraphicsContext gc;

    public DrawingObject(double x, double y, double width, double height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        gc = getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        setTranslateX(x);
        setTranslateY(y);
        setWidth(width);
        setHeight(height);
    }

    public abstract void draw();

    public boolean collisionDetection(DrawingObject object) {
        if (getX() >= object.getX() && getX() <= object.getX() + object.getWIDTH()
                || getX() + getWIDTH() >= object.getX() && getX() + getWIDTH() <= object.getX() + object.getWIDTH()) {
            if (getY() >= object.getY() && getY() <= object.getY() + object.getHEIGHT()
                    || getY() + getHEIGHT() >= object.getY() && getY() + getHEIGHT() <= object.getY() + object.getHEIGHT()) {
                return true;
            }
        }
        return false;
    }

    protected void filpCanvas() {
        setScaleX(-getScaleX());
    }

    public double getX() {
        return getTranslateX();
    }

    public double getY() {
        return getTranslateY();
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

}
