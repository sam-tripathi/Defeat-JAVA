public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("rectangle.width= " + rectangle.getWidth()); /* rectangle.width= 5.0 */
        System.out.println("rectangle.length= " + rectangle.getLength());/* rectangle.length= 10.0 */
        System.out.println("rectangle.area= " + rectangle.getArea());/* rectangle.area= 50.0 */
        Cuboid cuboid = new Cuboid(5, 10, 5);
        System.out.println("cuboid.width= " + cuboid.getWidth());/* cuboid.width= 5.0 */
        System.out.println("cuboid.length= " + cuboid.getLength());/* cuboid.length= 10.0 */
        System.out.println("cuboid.area= " + cuboid.getArea());/* cuboid.area= 50.0 */
        System.out.println("cuboid.height= " + cuboid.getHeight());/* cuboid.height= 5.0 */
        System.out.println("cuboid.volume= " + cuboid.getVolume());/* cuboid.volume= 250.0 */

        rectangle.thisIS();/* This is class Rectangle */
        cuboid.thisIS();/* This is class Cuboid and My Parent class is class Cuboid */

    }
}
