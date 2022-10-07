package com.fenixhub.Matrix;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
abstract class AbstractGenericMatrix<T> {
    
    protected T[][] matrix;

    protected abstract Class<? extends T> getClazz();

    protected AbstractGenericMatrix() {
        this.matrix = (T[][]) Array.newInstance(getClazz(), 0, 0);
    }

    protected AbstractGenericMatrix(int nRows, int nColumns) {
        this.matrix = (T[][]) Array.newInstance(getClazz(), nRows, nColumns);
    }

    public AbstractGenericMatrix(T[][] matrix) {
        this.matrix = matrix;
    }

    protected abstract void setMatrix(T[][] matrix);

    protected abstract T[][] getArrayCopy();

    protected abstract T[][] getArrayCopy(int rowOffset, int columnOffset, int nRows, int nColumns);

    protected abstract AbstractGenericMatrix<T> setRow(int index, T[] row);

    protected abstract AbstractGenericMatrix<T> insertRow(int index, T[] row);

    protected abstract AbstractGenericMatrix<T> setColumn(int index, T[] column);

    protected abstract AbstractGenericMatrix<T> insertColumn(int index, T[] column);

    protected abstract AbstractGenericMatrix<T> set(int row, int column, T value);

    protected abstract T[] getRow(int index);

    protected abstract int getRows();

    protected abstract T[] getColumn(int index);

    protected abstract int getColumns();

    protected abstract T get(int row, int column);

    protected abstract int[] getSize();

    protected abstract AbstractGenericMatrix<T> resize(int fromRow, int fromColumn, int toRow, int toColumn);

    protected abstract AbstractGenericMatrix<T> getMatrix(int rowOffset, int columnOffset, int nRows, int nColumns);
    
    protected abstract AbstractGenericMatrix<T> getMatrix(int nRows, int nColumns);


}
