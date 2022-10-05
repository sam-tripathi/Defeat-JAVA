package com.company;

import java.util.Scanner;

public class Parallelogram {
    public static void main(String[] args) {
        int A;
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter the value of b");
        int b = in.nextInt();
        System.out.println("Enter the value of h");
        int h = in.nextInt();

           A =b*h;
        System.out.println("Area of Parallelogram ="+ A);
    }
}
