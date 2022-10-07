package com.KKDSA.Area;

import java.util.Scanner;

public class AreaOfRhombus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String option;
        do {
            System.out.println("Enter 1 if you have height and base");
            System.out.println("Enter 2 if you have diagonals");
            System.out.println("Enter 'x' to exit");
            option = sc.nextLine();
            switch (option) {
                case "1" -> {
                    System.out.println("Enter height: ");
                    double height = sc.nextDouble();
                    System.out.println("Enter base:");
                    double base = sc.nextDouble();
                    double area = base * height;
                    System.out.println("The area of rhombus is " + area);
                }
                case "2" -> {
                    System.out.println("Enter diagonal 1: ");
                    double diagonal1 = sc.nextDouble();
                    System.out.println("Enter diagonal 2: ");
                    double diagonal2 = sc.nextDouble();
                    double area = (0.5) * diagonal1 * diagonal2;
                    System.out.println("The area of rhombus is " + area);
                }
                case "x" -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        } while (true);
    }
}