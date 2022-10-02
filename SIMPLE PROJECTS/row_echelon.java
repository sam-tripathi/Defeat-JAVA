package com.company;
import java.util.Scanner;
// row echelon form of any matrix

public class Main{

    public static boolean isNotTriangular(double[][] matrix){
    int n = matrix.length;
    int m = matrix[0].length;
    int a = 0;
    if(n>m)
        a=m;
    else
        a=n;
    for(int i=0;i<a;i++){
     for(int j=0;j<i;j++){
         if(matrix[i][j]!=0){return true;}
     }

    }
    return false;
    }

    public static double[][] swap(double[][] matrix, int a , int b){
        int columns = matrix.length;
        for(int i=0;i<columns;i++){
            double temp = matrix[a][i];
            matrix[a][i] = matrix[b][i];
            matrix[b][i] = temp;
        }
        return matrix;
    }


    public static double[][] abc (double[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int a = 0;
        if(n>m)
            a=m;
        else
            a=n;

        // swapping process
        for (int i = 0; i < a; i++) {
            if (matrix[i][i] == 0) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] != 0 && i > j) {
                        swap(matrix, i, j);
                        break;
                    }

                    if (i < j) {
                        swap(matrix, i, j);
                        break;
                    }
                }
            }

        }
          return matrix;


    }

    public static double[][] rowechelon(double matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        int a;
        if(n>m)
            a=m;
        else
            a=n;
        int i = 0;
        while(i<a){
            if(matrix[i][i]!=0){
                for(int l=i+1;l<n;l++){
                    double x = matrix[l][i]/matrix[i][i];
                    for(int k=0;k<m;k++){
                        double ab = matrix[l][k] - x*matrix[i][k];
                        matrix[l][k] = ab;
                    }
                } }
            i++;
        }

       while(isNotTriangular(matrix)){
           rowechelon(abc(matrix));
       }

        return matrix;
    }

    //method to display matrix

    public static void displayMatrix(double[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                System.out.print(Math.floor(10*matrix[j][i])/10+" ");
            }
            System.out.println(" ");
        }

    }

    public static void main(String[] args){
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     int m = in.nextInt();
     double[][] matrix = new double[n][m];
     for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
             matrix[i][j]= in.nextDouble();
         }
     }

        System.out.println(" ");
     displayMatrix(rowechelon(abc(matrix)));

    }
}
