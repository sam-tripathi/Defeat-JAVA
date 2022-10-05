package com.company;

import java.util.Scanner;
import java.lang.Math;

public class VolOfCon {
    public static void main(String[] args) {
        double V;
        final float PI = 3.14159f;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value  of radius");
        int r = in.nextInt();
        System.out.println("Enter the value of height");
        int h = in.nextInt();

          V = (PI*(Math.pow(r,2))*h)/3;

        System.out.println("Volume Of Cone = " + V);



    }
}
