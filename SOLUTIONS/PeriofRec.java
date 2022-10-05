package com.company;

import java.util.Scanner;

public class PeriofRec {
    public static void main(String[] args) {
        int P;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of Length " );
        int l = in.nextInt();
        System.out.println("Enter the value of Width");
        int w = in.nextInt();

                 P = 2*(l+w);
        System.out.println("Perimeter of Rectangle = " + P);
    }
}
