package com.company;

import java.util.Scanner;

public class Isosceles {
    public static void main(String[] args) {
        int A;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value b");
        int b = in.nextInt();
        System.out.println("Enter the value h");
        int h = in.nextInt();
              A= b*h/2;
        System.out.println("Area of Isoceles=" + A );

    }

}
