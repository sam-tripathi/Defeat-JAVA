package com.company;

import java.util.Scanner;

public class periofcir {
    public static void main(String[] args) {
        float P;
        float pi = 3.14159f;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of radius");
        int r = in.nextInt();
                P = 2*pi*r;
        System.out.println("Perimeter of Circle = " + P);
    }
}
