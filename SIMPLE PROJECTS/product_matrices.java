package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int max = 0;
        int min = -3;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the order of square matrix");
        int n = in.nextInt();
        //Code to find 2 Cartan Matrices
        int matrix1[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                matrix1[i][j]= (int)Math.random()*4-3;
            }
            matrix1[i][i]=2;
        }
        for(int i=0;i<n;i++) {
            for (int j = i; j < n; j++) {
                if(matrix1[i][j]==0){matrix1[j][i]=0;}
            }
        }
        int matrix2[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                matrix2[i][j]= (int)Math.random()*4-3;
            }
            matrix2[i][i]=2;
        }
        for(int i=0;i<n;i++) {
            for (int j = i; j < n; j++) {
                if(matrix2[i][j]==0){matrix2[j][i]=0;}
            }
        }
        // code ends

        // code to compute the product
        int productMatrix[][] = new int[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = 0;
                for(int k=0;k<n;k++){
                    sum = sum + matrix1[i][k]*matrix2[k][j];
                }
                productMatrix[i][j] = sum;
                System.out.print(productMatrix[i][j]+" ");
            }
            System.out.println(" ");
        }




    }
}

Case Example:
Enter the order of square matrix
5
4 -12 -3 6 15  
0 4 -12 -3 6  
0 0 4 -12 -3  
0 0 0 4 -12  
0 0 0 0 4 
