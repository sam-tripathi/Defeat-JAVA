package com.KKDSA.perimeter;

import java.util.Scanner;

public class PerimeterOfSquare {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 to find perimeter.");
            System.out.println("Enter 2 to exit the code.");
            int option = sc.nextInt();
            if(option == 1) {
                System.out.println("Enter side");
                double side = sc.nextDouble();
                double perimeter = Math.pow(side,2);
                System.out.println("The area of circle is: " + perimeter);
            } else if (option == 2) {
                break;
            }else{
                System.out.println("Invalid option");
            }
        } while (true);
    }
}
