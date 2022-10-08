package com.fenixhub.matrix.utilities;

import com.fenixhub.exceptions.MatrixOperationException;
import com.fenixhub.matrix.classes.GenericMatrix;

@SuppressWarnings("unchecked")
public class MatrixOperations {
    
    public static <T> T castDouble(Double value, Class<T> clazz) {
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

    public static <T extends Number> double castT(T value, Class<T> clazz) {
        if (clazz == Integer.class) {
            return value.intValue();
        } else if (clazz == Long.class) {
            return value.longValue();
        } else if (clazz == Float.class) {
            return value.floatValue();
        } else if (clazz == Double.class) {
            return value.doubleValue();
        } else {
            return value.doubleValue();
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
                result.set(i, j, castDouble(temp, a.getClazz()));
            }
        }
        return result;
    }

    // Sum two matrices
    public static <T extends Number> GenericMatrix<T> sum(GenericMatrix<T> a, GenericMatrix<T> b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            throw new MatrixOperationException(a, b);
        }
        
        GenericMatrix<T> tempMatrix = new GenericMatrix<T>(a.getRows(), a.getColumns(), a.getClazz());
        
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                tempMatrix.set(i, j, castDouble(a.get(i, j).doubleValue() + b.get(i, j).doubleValue(), a.getClazz()));
            }
        }
        
        return tempMatrix;
    }

    // Calculates dot product of two matrices, A*B
    public static <T extends Number> GenericMatrix<T> dot(GenericMatrix<T> a, GenericMatrix<T> b) {
        if (a.getColumns() != b.getRows()) {
            throw new MatrixOperationException("Expected A columns to be equal to B rows, but got A columns = " 
            + a.getColumns() + " and B rows = " + b.getRows() + " instead.");
        }

        Double sum = 0.0;

        GenericMatrix<T> result = new GenericMatrix<T>(a.getRows(), b.getColumns(), a.getClazz());
        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                sum = 0.0;
                for (int k = 0; k < a.getColumns(); k++) {
                    sum += a.get(i, k).doubleValue() * b.get(k, j).doubleValue();
                }
                result.set(i, j, castDouble(sum, a.getClazz()));
            }
        }
        return result;
    }

    // Calculate hadamard of two matrix A and B
    public static <T extends Number> GenericMatrix<T> hadamard(GenericMatrix<T> a, GenericMatrix<T> b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            throw new MatrixOperationException(a, b);
        }

        GenericMatrix<T> result = new GenericMatrix<T>(a.getRows(), a.getColumns(), a.getClazz());
        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                result.set(i, j, castDouble(a.get(i, j).doubleValue() * b.get(i, j).doubleValue(), a.getClazz()));
            }
        }
        return result;
    }

    public static <T extends Number> T max(GenericMatrix<T> matrix) {
        double max = matrix.get(0, 0).doubleValue();
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if (matrix.get(i, j).doubleValue() > max) {
                    max = matrix.get(i, j).doubleValue();
                }
            }
        }
        return castDouble(max, matrix.getClazz());
    }

    public static <T extends Number> T min(GenericMatrix<T> matrix) {
        double min = matrix.get(0, 0).doubleValue();
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if (matrix.get(i, j).doubleValue() < min) {
                    min = matrix.get(i, j).doubleValue();
                }
            }
        }
        return castDouble(min, matrix.getClazz());
    }

    public static <T extends Number> double avg(GenericMatrix<T> matrix) {
        double sum = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                sum += matrix.get(i, j).doubleValue();
            }
        }
        return sum / (matrix.getRows() * matrix.getColumns());
    }

    public static <T extends Number> double determinant(GenericMatrix<T> matrix) {
        
        
        if (!matrix.isSquare()) {
            throw new MatrixOperationException("Expected square matrix, but got " + matrix.getRows() + " rows and " + matrix.getColumns() + " columns instead.");
        }

        double determinat = 0.0;
        
        if (matrix.isDiagonal() || matrix.isTriangular()) {
            for (int i = 0; i < matrix.getRows(); i++) {
                determinat *= matrix.get(i, i).doubleValue();
            }
        }
        else if (matrix.getRows() == 2) {
            determinat = matrix.get(0, 0).doubleValue() * matrix.get(1, 1).doubleValue() 
            - matrix.get(0, 1).doubleValue() * matrix.get(1, 0).doubleValue();
        }
        else if (matrix.isIdentity()) {
            determinat = 1.;
        }
        else {
            // Laplace expansion
            short multiplier = -1;            
            GenericMatrix<T> submatrix = matrix.getMatrix(1, 0, matrix.getRows(), matrix.getColumns());
            for (int j = 0; j < matrix.getColumns(); j++) {
                GenericMatrix<T> cofactor = submatrix.copy().removeColumn(j);
                multiplier *= -1;
                determinat += multiplier * matrix.get(0, j).doubleValue() * determinant(cofactor); 
            }
        }

        return determinat;

    }

    public static <T extends Number> boolean equals(GenericMatrix<T> a, GenericMatrix<T> b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            return false;
        }
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                if (a.get(i, j).doubleValue() != b.get(i, j).doubleValue()) {
                    return false;
                }
            }
        }
        return true;
    }

}
