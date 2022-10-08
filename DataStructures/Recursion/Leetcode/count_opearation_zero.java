package com.leetcode;
import java.util.Scanner;
public class count_opearation_zero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        int answer = count_zero(num1,num2);
        System.out.println(answer);
    }
    static int count_zero(int num1, int num2)
    {
        if (num1 == 0 || num2 == 0)
            return 0;
        else if ( num1 >= num2)
            num1 = num1 - num2;
        else
            num2 = num2 - num1;

        return 1 + count_zero(num1, num2);
    }
}
