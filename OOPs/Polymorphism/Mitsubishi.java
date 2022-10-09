public class Mitsubishi extends Car {

    public Mitsubishi(int cylinders, String name) {
        /* The super keyword is used to call the parent class constructor */
        super(cylinders, name);
    }

    /*
     * This is the example of a Method overriding
     * There is one condition with method overriding we can't change the signature
     * of a method but we can change the implementation
     */

    @Override
    public String accelerate() {

        return "Mitsubishi -> accelerate()";
    }

    @Override
    public String brake() {

        return "Mitsubishi -> brake ()";
    }

    @Override
    public String startEngine() {

        return "Mitsubishi -> startEngine()";
    }

}
