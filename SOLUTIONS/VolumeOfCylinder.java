package com.recursion_array;
import java.util.*;
import java.lang.Math;

public class VolumeOfCylinder {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        float V,r,h;
        int choice;
       do{
            System.out.println("Which parameter of cylinder you want to find out");
            System.out.println("0.Exit");
            System.out.println("1.Volume");
            System.out.println("2.Radius");
            System.out.println("3.Height");
            choice=in.nextInt();
           switch (choice) {
               case 0 -> System.exit(0);
               case 1 -> {
                   System.out.println("Enter radius");
                   r = in.nextFloat();
                   System.out.println("Enter height");
                   h = in.nextFloat();
                   V = (float) (Math.PI) * r * r * h;
                   System.out.println("Volume is: " + V);
               }
               case 2 -> {
                   System.out.println("Enter volume");
                   V = in.nextFloat();
                   System.out.println("Enter height");
                   h = in.nextFloat();
                   r = (float) Math.sqrt(V / (float) (Math.PI * h));
                   System.out.println("Radius is: " + r);
               }
               case 3 -> {
                   System.out.println("Enter volume");
                   V = in.nextFloat();
                   System.out.println("Enter radius");
                   r = in.nextFloat();
                   h = V / (float) (Math.PI * r * r);
                   System.out.println("Height is: " + h);
               }
               default -> System.out.println("Andha hai kya option nhi dikh rahe");
           }
        }while (choice!=0);
    }
}
