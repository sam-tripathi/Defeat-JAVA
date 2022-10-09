/*
 * Parent Class/ Base Class
 */

public class Rectangle {
    private double width, length;

    public Rectangle(double width, double length) {
        this.width = width < 0 ? 0 : width;
        this.length = length < 0 ? 0 : length;
    }

    public void thisIS() {
        System.out.println("This is " + this.getClass());
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return this.length * this.width;
    }

}
