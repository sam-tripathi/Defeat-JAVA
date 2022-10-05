package com.company;

import java.util.Scanner;

public class Areaofrect {
    public static void main(String[] args) {
        int A;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of length");
        int l = in.nextInt();
        System.out.println("Enter the value of width");
        int w = in.nextInt();

               A = l*w;
        System.out.println(" Area of Rectangle = "+ A);
    }

}
