package model;

import javafx.scene.paint.Color;

public class Background extends DrawingObject {

    public Background() {
        super(0, 0, 600, 600);
    }

    public void draw() {
        gc.setFill(Color.WHEAT);
        gc.fillRect(0, 0, 600, 600);
        for (double y = 50; y <= 600; y += 50) {
            gc.strokeLine(0, y, 600, y);
            if (y % 150 == 0) {
                drawWood(50, y, 0, 150);
            } else if (y % 100 == 0) {
                drawWood(125, y, 150, 50);
            } else if (y % 50 == 0) {
                drawWood(250, y, 50, 100);
            }
        }
    }

    private void drawWood(double tmpX, double y, int tmp, int inc) {
        for (double x = tmpX; x < 600; x += tmp) {
            gc.strokeLine(x, y , x + 50, y - 50);
            tmp += inc;
        }
    }

}
