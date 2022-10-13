//basic program on Classes and Objects in Java
class Test {
    boolean isTrue;

    // method to turn on the light
    void turnOn() {
        isTrue = true;
        System.out.println("Test Pass? " + isTrue);

    }

    // method to turnoff the light
    void turnOff() {
        isTrue = false;
        System.out.println("Test Pass? " + isTrue);
    }
}

class Main {
    public static void main(String[] args) {

        Test classTest = new Test();
        Test trial = new Test();

        classTest.turnOn();

        trial.turnOff();
    }
}