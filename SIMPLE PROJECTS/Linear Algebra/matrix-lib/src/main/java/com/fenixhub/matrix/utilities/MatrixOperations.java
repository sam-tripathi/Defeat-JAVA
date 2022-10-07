package com.fenixhub.matrix.utilities;

import com.fenixhub.exceptions.MatrixSizeException;
import com.fenixhub.matrix.classes.GenericMatrix;

@SuppressWarnings("unchecked")
public class MatrixOperations {
    
    public static <T> T cast(Double value, Class<T> clazz) {
        if (clazz == Integer.class) {
            return (T) clazz.cast(value.intValue());
        } else if (clazz == Long.class) {
            return (T) clazz.cast(value.longValue());
        } else if (clazz == Float.class) {
            return (T) clazz.cast(value.floatValue());
        } else if (clazz == Double.class) {
            return (T) clazz.cast(value.doubleValue());
        } else {
            return (T) value;
        }
    }

    // Transpose a matrix
    public static <T extends Number> GenericMatrix<T> transpose(GenericMatrix<T> matrix) {
        GenericMatrix<T> tempMatrix = new GenericMatrix<T>(matrix.getColumns(), matrix.getRows(), matrix.getClazz());
        
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                tempMatrix.set(j, i, (T) matrix.get(i, j));
            }
        }
        
        return tempMatrix;
    }


    // Calculate scalar product of matrix A for scalar s
    public static <T extends Number> GenericMatrix<T> scalar(GenericMatrix<T> a, T s) {
        GenericMatrix<T> result = new GenericMatrix<T>(a.getRows(), a.getColumns(), a.getClazz());
        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                double temp = a.get(i, j).doubleValue() * s.doubleValue();
                result.set(i, j, cast(temp, a.getClazz()));
            }
        }
        return result;
    }

    // Sum two matrices
    public static <T extends Number> GenericMatrix<T> sum(GenericMatrix<T> a, GenericMatrix<T> b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            throw new MatrixSizeException("Matrices must have the same size.");
        }
        
        GenericMatrix<T> tempMatrix = new GenericMatrix<T>(a.getRows(), a.getColumns(), a.getClazz());
        
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                tempMatrix.set(i, j, cast(a.get(i, j).doubleValue() + b.get(i, j).doubleValue(), a.getClazz()));
            }
        }
        
        return tempMatrix;
    }

    // Calculates dot product of two matrices, A*B
    public static <T extends Number> GenericMatrix<T> dot(GenericMatrix<T> a, GenericMatrix<T> b) {
        if (a.getColumns() != b.getRows()) {
            throw new MatrixSizeException("Expected A columns to be equal to B rows, but got A columns = " 
            + a.getColumns() + " and B rows = " + b.getRows() + " instead.");
        }

        Double sum = 0.0;

        GenericMatrix<T> result = new GenericMatrix<T>(a.getRows(), b.getColumns(), a.getClazz());
        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                for (int k = 0; k < a.getColumns(); k++) {
                    sum += a.get(i, k).doubleValue() * b.get(k, j).doubleValue();
                }
                result.set(i, j, cast(sum, a.getClazz()));
            }
        }
        return result;
    }

    // Calculate hadamard of two matrix A and B
    public static <T extends Number> GenericMatrix<T> hadamard(GenericMatrix<T> a, GenericMatrix<T> b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            throw new MatrixSizeException("Expected A and B to have same dimensions, but got A dimensions = " 
            + a.getRows() + "x" + a.getColumns() + " and B dimensions = " + b.getRows() + "x" + b.getColumns() + " instead.");
        }

        GenericMatrix<T> result = new GenericMatrix<T>(a.getRows(), a.getColumns(), a.getClazz());
        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                result.set(i, j, cast(a.get(i, j).doubleValue() * b.get(i, j).doubleValue(), a.getClazz()));
            }
        }
        return result;
    }

}
