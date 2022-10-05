package com.company;

import java.util.Scanner;

public class Areaofcircle {
    public static void main(String[] args) {
        double A;
        float pi =  3.14159f;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of r");
        int r = in.nextInt();
        A = pi*r*r;
        System.out.println("Area of circle="+A);
    }
}
