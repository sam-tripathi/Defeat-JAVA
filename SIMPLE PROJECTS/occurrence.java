package com.practicekk;

import java.util.Scanner;

public class occurrence {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the number: ");
         int n = sc.nextInt();
           int count = 0;
           System.out.println("Enter the number to count to its occurrence: ");
           int a = sc.nextInt();
           while(n > 0) {
           int rem = n % 10;
           if(rem == a){
            count++;
        }
        n = n / 10;
    }
    System.out.println(count);
    sc.close();
}
}


