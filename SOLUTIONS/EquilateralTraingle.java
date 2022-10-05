package com.company;

import java.util.Scanner;

public class EquilateralTraingle {
    public static void main(String[] args) {
        double A;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of side");
        float a = in.nextFloat();
           A= (Math.sqrt(3)*a*a)/4;
        System.out.println("Area Of Equilateral Triangle = " + A);
    }
}
