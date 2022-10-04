import java.util.*;;
public class multi extends Thread {
    public void run(){
    String bird[]={"eagle","chara","kag","parewa","charano5"};
    int arrlength = bird.length;
    for(int i = 0; i < arrlength; i++){
        System.out.println(bird[i]);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
}
 class multi2 extends Thread{
    public void run(){
        String animal[]={"bhag","valu","ghoda"};
        for(int i =0;i< animal.length;i++){
            System.out.println(animal[i]);
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
            }
        }
}
 }
 class Runing {
    public static void main(String[] args){
        multi b = new multi();
        multi2 a = new multi2();

        b.start();
        a.start();
    }
 }

