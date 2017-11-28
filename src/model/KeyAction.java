package model;

public class KeyAction {

    private Cat cat;
    private boolean isMoveUp, isMoveDown, isMoveRight, isMoveLeft;

    public KeyAction(Cat cat) {
        this.cat = cat;
    }

    public void action() {
        if (isMoveUp) cat.moveUp();
        if (isMoveDown) cat.moveDown();
        if (isMoveLeft) cat.moveLeft();
        if (isMoveRight) cat.moveRight();
    }

    public void setMoveUp(boolean moveUp) {
        isMoveUp = moveUp;
    }

    public void setMoveDown(boolean moveDown) {
        isMoveDown = moveDown;
    }

    public void setMoveRight(boolean moveRight) {
        isMoveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        isMoveLeft = moveLeft;
    }

}
