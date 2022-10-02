package SaveFormat;

import Ball.Ball;

import java.io.Serializable;

public class BallFormat implements Serializable {
    private String color;
    private int x,y;
    private static final long serialVersionUID = 2L;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void saveBall (Ball ball) {
        this.color = ball.getBallColor().toString();
        this.x = ball.getX();
        this.y = ball.getY();

    }

}
