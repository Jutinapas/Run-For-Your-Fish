package model;

import javafx.scene.paint.Color;

public class SunnyCat extends Cat {

    public SunnyCat(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw() {
        drawTail(Color.WHITE);
        drawBody(Color.WHITE);
        drawHead(Color.GRAY, Color.GOLD, Color.WHITE);
        drawFace(Color.BLACK);
        drawLegs(Color.WHITE);
    }

    @Override
    protected void drawBody(Color c1){
        super.drawBody(c1);
        gc.setFill(Color.GOLD);
        gc.fillOval(40,20, 40, 20);
        gc.setFill(Color.GRAY);
        gc.fillOval(65, 32.5, 25, 20);
    }

    @Override
    protected void drawHead(Color c1, Color c2, Color c3) {
        super.drawHead(c1, c2, c3);
        gc.setFill(Color.GOLD);
        gc.fillOval(35,10, 20, 25);
    }

}
