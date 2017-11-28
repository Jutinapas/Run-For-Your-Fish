package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class GingerCat extends Cat {

    public GingerCat(double x, double y) {
        super(x, y);
    }

    public void draw() {
        drawTail(Color.WHITE);
        drawBody(Color.SANDYBROWN);
        drawHead(Color.WHITE, Color.WHITE, Color.SANDYBROWN);
        drawFace(Color.BLACK);
        drawLegs(Color.WHITE);
    }

    @Override
    protected void drawTail(Color c1) {
        super.drawTail(c1);
    }

    @Override
    protected void drawBody(Color c1){
        super.drawBody(c1);
    }

    @Override
    protected void drawHead(Color c1, Color c2, Color c3) {
        super.drawHead(c1, c2, c3);
    }

    @Override
    protected void drawFace(Color c1) {
        super.drawFace(c1);
        gc.setFill(Color.WHITE);
        gc.fillOval(20.5, 30, 24,12);
        gc.strokeArc(25,30,7,7, 170, 180, ArcType.OPEN);
        gc.strokeArc(32,30,7,7, 180, 190, ArcType.OPEN);
    }

}
