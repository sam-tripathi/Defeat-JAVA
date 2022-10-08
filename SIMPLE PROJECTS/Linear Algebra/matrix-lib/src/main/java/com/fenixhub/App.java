package com.fenixhub;

import com.fenixhub.matrix.builders.GenericMatrixBuilder;
import com.fenixhub.matrix.classes.GenericMatrix;
import com.fenixhub.matrix.utilities.MatrixOperations;

public class App 
{
    public static void main( String[] args )
    {
        GenericMatrix<Float> matrix1 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {1.0f},
            {3.0f}
        })
        .build();

        GenericMatrix<Float> matrix2 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {2.0f, 4.0f}
        })
        .build();

        System.out.println(MatrixOperations.dot(matrix1, matrix2));
    }
}
