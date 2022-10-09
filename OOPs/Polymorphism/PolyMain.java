/**
 * Main
 */
public class PolyMain {

    public static void main(String[] args) {

        /*
         * There are two techniques to achieve polymorphism in Java
         * 1. Method OverLoading
         * 2.Method Overriding
         */
        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine()); /* Car -> startEngine() */
        System.out.println(car.accelerate());/* Car -> accelerate() */
        System.out.println(car.brake());/* Car -> brake() */

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());/* Mitsubishi -> startEngine() */
        System.out.println(mitsubishi.accelerate());/* Mitsubishi -> accelerate() */
        System.out.println(mitsubishi.brake());/* Mitsubishi -> brake () */
    }
}
