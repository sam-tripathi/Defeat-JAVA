package com.company;

import java.util.Scanner;

public class PeriofSqur {
    public static void main(String[] args) {
        int P;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of side ");
        int a = in.nextInt();
             P = 4*a;
        System.out.println("Perimeter of Square = " + P);
    }
}
