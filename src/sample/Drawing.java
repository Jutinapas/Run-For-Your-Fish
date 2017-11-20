package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Drawing extends Canvas {

    protected GraphicsContext gc;

    public Drawing(double x, double y, double width, double height) {
        gc = getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        setTranslateX(x);
        setTranslateY(y);
        setWidth(width);
        setHeight(height);
    }

    protected void filpCanvas() {
        setScaleX(-getScaleX());
    }

}
