//creating objects in same class
class Bike {

  boolean isOn;

  void turnOn() {
    isOn = true;
    System.out.println("Bike on? " + isOn);

  }

  public static void main(String[] args) {

    // create an object of Bike
    Bike engine = new Bike();

    engine.turnOn();
  }
}