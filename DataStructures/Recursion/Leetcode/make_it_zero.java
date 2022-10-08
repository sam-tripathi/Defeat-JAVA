package com.leetcode;

public class make_it_zero {
    static int c  = 0;
    public static void main(String[] args) {
        int n = 8;
        int answer = make_zero(n);
        System.out.println(answer);
    }
     static int make_zero(int n) {
        if ( n == 0){
            return c;
        }
        if (n % 2 == 0){
            ++c;
            return make_zero(n/2);
        }
         ++c;
        return make_zero(n-1);
    }

}
