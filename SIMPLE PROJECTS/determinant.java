// gives determinant of nxn matrix
package com.company;

import java.util.*;

public class Main {
// finding determinant.
    // cofactor function
    // making a submatrix then finding the determinant out of it using recursion
    public static int cofactor(int[][] matrix,int i ){
        int n = matrix.length;
        int ans = matrix[0][i]*((int)Math.pow(-1,i));
        return ans;
    }
    public static int[][] correspondingSubMatrix(int[][] matrix,int j){
        int n = matrix.length;
        //function to find submatrix
        int [][] ans = new int[n-1][n-1];
        // function to find sub matrix
        for(int k = 1;k<n;k++){
            int b =0;
            for(int l=0;l<n;l++){
                if(l!=j){ans[k-1][b]= matrix[k][l];
                    b++;
                }
            }
        }

        return ans;
    }
    public static int determinant(int[][] matrix){
        int n = matrix.length;
        if(n==1){return matrix[0][0];}
        if(n==2){return (matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1]);}
        int det= 0;
        for(int i=0;i<n;i++){
            det += cofactor(matrix,i)*determinant(correspondingSubMatrix(matrix,i));
        }
        return det;
    }


    public static void main(String[] args) {
    // taking matrix as input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println(determinant(matrix));
    }
}
