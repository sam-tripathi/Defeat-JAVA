package com.company;

public class concept {
    public static void main(String[] args) {
        subtact(5);
    }
    static void subtact(int n)
    {
        if ( n == 0)
        {
            return;
        }
        System.out.println(n);
        subtact(--n);
    }

}

if we change subtact(--n) to subtact(n--) it is give 
a stackoverflow error