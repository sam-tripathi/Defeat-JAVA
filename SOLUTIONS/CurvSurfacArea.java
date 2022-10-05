package com.company;

import java.util.Scanner;

public class CurvSurfacArea {
    public static void main(String[] args) {
        float C;
        float pi = 3.14159f;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of Radius");
        int r = in.nextInt();
        System.out.println(" Enter the value of Height");
        int h = in.nextInt();

               C = 2*(pi*r*h);
        System.out.println("Curved Surface Area = " + C);
    }
}
