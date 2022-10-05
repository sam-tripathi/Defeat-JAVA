package com.company;

import java.util.Scanner;

public class Areaoftraingle {
    public static void main(String[] args) {
        double A ;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of Base");
        int b = in.nextInt();
        System.out.println("Enter the value of Height");
        int h = in.nextInt();
        A = (b*h)*0.5;
        System.out.println("Area of triangle="+A);

    }
}


//  if  Area  gives  point value then use - double