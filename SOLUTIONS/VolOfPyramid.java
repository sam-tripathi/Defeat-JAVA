package com.company;

import java.util.Scanner;

public class VolOfPyramid {
    public static void main(String[] args) {
        int V;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of length ");
        int l = in.nextInt();
        System.out.println("Enter the value of Width");
        int w = in.nextInt();
        System.out.println("Enter the value of height");
        int h = in.nextInt();
             V = (l*w*h)/3;
        System.out.println("Volume of Pyramid = " + V);
    }
}
