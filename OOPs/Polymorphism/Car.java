public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;
    private String color;

    /* Constructor overloading is a very good example of Mehod Overloading */
    /*
     * In Method Overloading we can use the same method name with a different
     * signature
     * that means with a different number of parameters or a different return type.
     */

    public Car(int cylinders, String name, String color) {
        this.cylinders = cylinders;
        this.name = name;
        this.color = color;
        this.engine = true;
        this.wheels = 4;
    }

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
        this.color = "White";
    }

    public String getColor() {
        return color;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return "Car -> startEngine()";
    }

    public String accelerate() {
        return "Car -> accelerate()";
    }

    public String brake() {
        return "Car -> brake()";
    }

}
