package com.fenixhub;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.fenixhub.Matrix.IntegerMatrix;
import com.fenixhub.Matrix.IntegerMatrixBuilder;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        IntegerMatrix matrix = new IntegerMatrix(new Integer[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });

        System.out.println(matrix);
        System.out.println("Rows: " + matrix.getRows());
        System.out.println("Columns: " + matrix.getColumns());

        System.out.println("Row 0: " + Arrays.toString(matrix.getRow(0)));
        System.out.println("Column 0: " + Arrays.toString(matrix.getColumn(0)));        
        System.out.println("");

        System.out.println("Inserting row at index 1");
        matrix.insertRow(1, new Integer[]{10, 11, 12});
        System.out.println(matrix);

        System.out.println("Inserting column at index 1");
        matrix.insertColumn(1, new Integer[]{13, 14, 16, 17});
        System.out.println(matrix);

        System.out.println("Getting subarray 2x2 from index 0, 0");
        System.out.println(matrix.getMatrix(2, 2));

        // System.out.println("Generating a random matrix with a MatrixBuilder");
        // IntegerMatrix newMatrixFromBuilder = new IntegerMatrixBuilder()
        // .ofRandom(10, 10, -20, 20)
        // .build();

        // System.out.println(newMatrixFromBuilder);
    }
}
