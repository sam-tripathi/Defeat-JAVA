package com.fenixhub.Matrix;

import java.lang.reflect.Array;

import com.fenixhub.Exceptions.MatrixSizeException;

@SuppressWarnings("unchecked")
public class GenericMatrix<T> extends AbstractGenericMatrix<T> {
    
    @Override
    protected Class<T> getClazz() {
        return (Class<T>) this.matrix.getClass().getComponentType().getComponentType();
    }

    public GenericMatrix() {
        super();
    }

    public GenericMatrix(int nRows, int nColumns) {
        super(nRows, nColumns);
    }

    public GenericMatrix(T[][] array) {
        super(array);
    }

    @Override
    public void setMatrix(T[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public T[][] getArrayCopy() {
        return matrix.clone();
    }

    protected T[][] getArrayCopy(int fromRow, int fromColumn, int toRow, int toColumn) {
        if (fromRow < 0 || fromRow >= getRows()) {
            throw new IndexOutOfBoundsException("From row index is out of bound.");
        }
        if (fromColumn < 0 || fromColumn >= getColumns()) {
            throw new IndexOutOfBoundsException("From column index is out of bound.");
        }
        if (toRow < 0 || toRow >= getRows()) {
            throw new IndexOutOfBoundsException("To row index is out of bound.");
        }
        if (toColumn < 0 || toColumn >= getColumns()) {
            throw new IndexOutOfBoundsException("To column index is out of bound.");
        }
        
        T[][] tempMatrix = (T[][]) Array.newInstance(getClazz(), toRow - fromRow, toColumn - fromColumn);

        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix[i].length; j++) {
                tempMatrix[i][j] = (T) matrix[fromRow + i][fromColumn + j];
            }
        }
        
        return tempMatrix;
    }


    @Override
    public GenericMatrix<T> setRow(int index, T[] row) {
        if (index < 0 || index >= matrix.length) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }
        if (row.length != matrix[index].length) {
            throw new MatrixSizeException("Row size is not valid.");
        }
        matrix[index] = row;
        return this;
    }

    @Override
    public GenericMatrix<T> insertRow(int index, T[] row) {
        if (index < 0 || index > getRows()) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }
        if (row.length != matrix.length) {
            throw new MatrixSizeException("Row size is not valid.");
        }

        T[][] tempMatrix = (T[][]) Array.newInstance(getClazz(), getRows() + 1, getColumns());
        for (int i = 0; i < tempMatrix.length; i++) {
            if (i < index) {
                tempMatrix[i] = matrix[i];
            } else if (i == index) {
                tempMatrix[i] = row;
            } else {
                tempMatrix[i] = matrix[i - 1];
            }
        }
        
        setMatrix(tempMatrix);
        return this;
    }

    @Override
    public GenericMatrix<T> setColumn(int index, T[] column) {
        if (index < 0 || index >= getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }
        if (column.length != matrix[0].length) {
            throw new MatrixSizeException("Column size is not valid.");
        }
        for (int i = 0; i < getRows(); i++) {
            matrix[i][index] = column[i];
        }
        return this;
    }

    @Override
    public GenericMatrix<T> insertColumn(int index, T[] column) {
        if (index < 0 || index > getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }
        if (column.length != matrix.length) {
            throw new MatrixSizeException("Column size is not valid.");
        }

        T[][] tempMatrix = (T[][]) Array.newInstance(getClazz(), getRows(), getColumns() + 1);
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix[i].length; j++) {
                if (j < index) {
                    tempMatrix[i][j] = matrix[i][j];
                } else if (j == index) {
                    tempMatrix[i][j] = column[i];
                } else {
                    tempMatrix[i][j] = matrix[i][j - 1];
                }
            }
        }

        setMatrix(tempMatrix);
        return this;
    }

    @Override
    public GenericMatrix<T> set(int row, int column, T value) {
        if (row < 0 || row >= getRows()) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }
        if (column < 0 || column >= getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }
        matrix[row][column] = value;
        return this;
    }

    @Override
    public T[] getRow(int index) {
        if (index < 0 || index >= getRows()) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }
        return matrix[index];
    }

    @Override
    public int getRows() {
        return matrix.length;
    }

    @Override
    public T[] getColumn(int index) {
        if (index < 0 || index >= getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }
        T[] column = (T[]) new Object[getRows()];
        for (int i = 0; i < getRows(); i++) {
            column[i] = matrix[i][index];
        }
        return column;
    }

    @Override
    public int getColumns() {
        return matrix[0].length;
    }

    @Override
    public T get(int row, int column) {
        if (row < 0 || row >= getRows()) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }
        if (column < 0 || column >= getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }
        return matrix[row][column];
    }

    @Override
    public int[] getSize() {
        return new int[] {getRows(), getColumns()};
    }

    @Override
    public GenericMatrix<T> getMatrix(int rowOffset, int columnOffset, int nRows, int nColumns) {
        return new GenericMatrix<T>(getArrayCopy(rowOffset, columnOffset, nRows, nColumns));
    }

    @Override
    public GenericMatrix<T> getMatrix(int rows, int columns) {
        return getMatrix(0, 0, rows, columns);
    }

    @Override
    public GenericMatrix<T> resize(int fromRow, int fromColumn, int toRow, int toColumn) {
        setMatrix(getArrayCopy(fromRow, fromColumn, toRow, toColumn));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }

}
