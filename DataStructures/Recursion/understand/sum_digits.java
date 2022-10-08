package com.company;
public class sum_digits {
    public static void main(String[] args) {
    int answer = sum_digit(1342);
        System.out.println(answer);
    }

    static int sum_digit(int n)
    {
        if (n  == 0)
        {
            return 0;
        }
        return n % 10 + sum_digit(n/10); //recursive caal
    }
}
