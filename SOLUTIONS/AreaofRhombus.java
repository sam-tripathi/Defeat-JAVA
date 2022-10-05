package com.company;

import java.util.Scanner;

public class AreaofRhombus {
    public static void main(String[] args) {
        int A;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of Dia1");
        int d1 = in.nextInt();
        System.out.println("Enter the value of Dia2");
        int d2 = in.nextInt();

              A= d1*d2/2;
        System.out.println("Area of Rhombus="+A);

    }
}
