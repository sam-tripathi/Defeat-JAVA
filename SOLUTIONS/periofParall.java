package com.company;

import java.util.Scanner;

public class periofParall {
    public static void main(String[] args) {
        double P;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of side");
        double a = in.nextInt();
        System.out.println("Enter the value of Base");
        double b = in.nextInt();

              P = 2*(a+b);
        System.out.println(" Perimeter of Parallelogram = " +P);
    }
}
