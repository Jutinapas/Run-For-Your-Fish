package sample;

import javafx.scene.paint.Color;

public class SmokeyCat extends Cat {

    public SmokeyCat(double x, double y) {
        super(x, y);
    }

    @Override
    protected void draw() {
        drawTail(Color.GRAY);
        drawBody(Color.GRAY);
        drawHead(Color.GRAY, Color.GRAY, Color.GRAY);
        drawFace(Color.YELLOW);
        drawLegs(Color.GRAY);
    }

    @Override
    public void drawTail(Color c1) {
        super.drawTail(c1);
    }

    @Override
    public void drawBody(Color c1) {
        super.drawBody(c1);
    }

    @Override
    public void drawHead(Color c1, Color c2, Color c3) {
        super.drawHead(c1, c2, c3);
    }

    @Override
    public void drawFace(Color c1) {
        super.drawFace(c1);
    }

    @Override
    public void drawLegs(Color c1) {
        super.drawLegs(c1);
    }

}
