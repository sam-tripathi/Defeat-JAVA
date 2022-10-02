package Obstacle;

import javafx.scene.shape.*;

public class Shape2D {

    private final Shape[] shapes = new Shape[6];

    public Shape2D() {
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Ellipse();
        shapes[3] = new Polygon();
        shapes[4] = new Polygon();
        shapes[5] = new Polygon();
    }
}
