package com.practicekk;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first term:");

        int FirstTerm = sc.nextInt();
        System.out.println("Enter the next term:");
        int NextTerm = sc.nextInt();
        System.out.println("Enter the nth term:");
        int n = sc.nextInt();
        int count = 2;
         while (count <= n){
             int temp = FirstTerm;
              FirstTerm = FirstTerm + NextTerm;
              NextTerm = temp;
              count++;
         }
        System.out.println(FirstTerm);

    }

    public static class MultiplicationTable {
        //with all three types of loops.
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int a = sc.nextInt();
            int i = 1;
    //        Using do while loop.
    //        do{
    //            int b = a * i;
    //            i++;
    //            System.out.println(b);
    //          }while(i <= 10);


    //        Using for loop.
    //        for(i=1; i<=10; i++){
    //        int b = a * i;
    //            System.out.println(b);
    //          }


    //        Using while loop
    //        while(i <=10){
    //            int b = a * i;
    //            i++;
    //            System.out.println(b);
    //           }
        }
    }
}