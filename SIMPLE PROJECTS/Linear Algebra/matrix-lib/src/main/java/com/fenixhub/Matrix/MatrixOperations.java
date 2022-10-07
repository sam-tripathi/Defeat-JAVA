package com.fenixhub.Matrix;

import com.fenixhub.Exceptions.MatrixSizeException;

public class MatrixOperations {
    
    // // Calculates dot product of two matrices, A*B
    // public static Matrix dot(Matrix a, Matrix b) {
    //     if (a.getColumns() != b.getRows()) {
    //         throw new MatrixSizeException("Expected A columns to be equal to B rows, but got A columns = " 
    //         + a.getColumns() + " and B rows = " + b.getRows() + " instead.");
    //     }
        
    //     Matrix result = new Matrix(a.getRows(), b.getColumns());
    //     for (int i = 0; i < result.getRows(); i++) {
    //         for (int j = 0; j < result.getColumns(); j++) {
    //             double sum = 0;
    //             for (int k = 0; k < a.getColumns(); k++) {
    //                 sum += a.get(i, k) * b.get(k, j);
    //             }
    //             result.set(i, j, sum);
    //         }
    //     }
    //     return result;
    // }

}
