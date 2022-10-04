import java.util.*;; 
public class multi extends Thread { //Made a child class multi form Thread
    public void run(){  //Public Void run is must in Thread
    String bird[]={"eagle","chara","kag","parewa","charano5"}; // First Array of Strings
    int arrlength = bird.length;
    for(int i = 0; i < arrlength; i++){ // The lopp runs till the last index number of the array. (5)
        System.out.println(bird[i]);
        try {
            Thread.sleep(1000); // Time dealy of the multi thread
        } catch (InterruptedException e) {
        }
    }
}
}
 class multi2 extends Thread{ //Made a child class multi2 form Thread
    public void run(){
        String animal[]={"bhag","valu","ghoda"}; // Second Array of Strings
        for(int i =0;i< animal.length;i++){ // The lopp runs till the last index number of the array. (3)
            System.out.println(animal[i]);
            try {
                Thread.sleep(2500); // Time dealy of the multi2 thread
            } catch (Exception e) {
            }
        }
}
 }
 class Runing {
    public static void main(String[] args){
        multi b = new multi(); //Made constructor of multi
        multi2 a = new multi2(); //Made constructor of multi2

        b.start(); //Called the run methord from multi class
        a.start(); //Called the run methord from multi2 class
    }
 }

