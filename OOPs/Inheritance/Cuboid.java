/* 
* Child Class
 * inherit all(not all) the properties and methods of a base class. 
 */
public class Cuboid extends Rectangle {
    private double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = height < 0 ? 0 : height;
    }

    /*
     * Method overriding
     */

    @Override
    public void thisIS() {
        System.out.println("This is " + this.getClass() + " and My Parent class is " + super.getClass());
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return this.getArea() * this.height;
    }

}
