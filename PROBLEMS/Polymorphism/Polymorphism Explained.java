package hacktoberfest_22;

public class Polymorphism {
    /* Polymorphism is one of core concept of OOPS. It means many forms(Poly-many). Polymorphism describes situations
       in which something occurs in several different forms.

       ~~Real world Example:
       We can take a boy as a real-world example. This boy can be a student, a player, and a writer.
       So that this boy can exist in different ways in different situations.

       Polymorphism if of two types:
       1. Static or Compile Time Polymorphism
       2. Dynamic or Runtime Polymorphism
     */

    // 1. Static or Compile Time Polymorphism

    /*As you can see the following three Functions have same name but they have different functionality depending
        upon the parameters. These methods are called run time polymorphism because JVM knows which function to call
        among these during compiling of program.

        **Method Overloading**
        When there are multiple functions with the same name but different parameters then these functions
        are said to be overloaded.
     */
    int add(int a, int b){  //fxn1
        return a+b;
    }
    int add(int a, int b, int c){ //fxn2
        return a+b+c;
    }
    String add(String str1, String str2){ //fxn3
        return str1+str2;
    }
    public static void main(String[] args) {
        System.out.println(add(2,3)); //calls fxn1, prints- 5
        System.out.println(add(10,20, 30)); //calls fxn2, prints- 60
        System.out.println(add("Poly", "Morphism")); //calls fxn3, prints- PolyMorphism
    }
}

    //2. Dynamic or Runtime Polymorphism
    /*
        This happens in function overriding. Function overloading means when a child class contains the method which is
        already present in parent class. Hence, child class overrides method of parent class.
     */

class Parent{
    void show(){
        System.out.println("This is Parent class");
    }
}
class Child extends Parent {
    //As you can notice here the child class is overriding the method show().
    void show(){
        System.out.println("This is child class");
    }
}

class Main{
    public static void main(String[] args) {
        Parent c = new Child();
        c.show(); 
        /*
         When an object of child class is created, then the method inside the child class is called. 
         This is because The method in the parent class is overridden by the child class. Since The method 
         is overridden, This method has more priority than the parent method inside the child class. So, the body 
         inside the child class is executed.
        */
    }
}
