package com.company;

import java.util.Scanner;

public class periofEqui {
    public static void main(String[] args) {
        int P;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of side");
        int a = in.nextInt();

            P = 3*a;
        System.out.println("Perimeter Of Equilateral Traingle = " + P);
    }
}
