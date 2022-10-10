class Car {
    int noOfWheels=4;
public void start(){
    System.out.println("car moves..");
}
class Inheritance extends Car{
    String color="red";
    public static void main(String args[]) {
        Inheritance obj=new Inheritance();
        System.out.println("No.of wheels: "+obj.noOfWheels);
        start();
        System.out.println("Color of the car:  "+obj.color);
    }

}
}