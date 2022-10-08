package com.fenixhub.matrix.classes;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
abstract class AbstractGenericMatrix<T extends Number> {
    
    public int formatPaddings = 4;

    protected T[][] array;

    protected abstract Class<? extends T> getClazz();

    protected abstract String getFormat();

    protected AbstractGenericMatrix(Class<T> clazz) {
        this.array = (T[][]) Array.newInstance(clazz, 0, 0);
    }

    protected AbstractGenericMatrix(int nRows, int nColumns, Class<T> clazz) {
        this.array = (T[][]) Array.newInstance(clazz, nRows, nColumns);
    }

    public AbstractGenericMatrix(T[][] array) {
        this.array = array;
    }

    public AbstractGenericMatrix(AbstractGenericMatrix<T> matrix) {
        this.array = matrix.getArrayCopy();
    }

    protected abstract void setArray(T[][] array);

    protected abstract T[][] getArrayCopy();

    protected abstract T[][] getArrayCopy(int rowOffset, int columnOffset, int nRows, int nColumns);

    protected abstract AbstractGenericMatrix<T> setRow(int index, T[] row);

    protected abstract AbstractGenericMatrix<T> insertRow(int index, T[] row);

    protected abstract AbstractGenericMatrix<T> removeRow(int index);

    protected abstract AbstractGenericMatrix<T> setColumn(int index, T[] column);

    protected abstract AbstractGenericMatrix<T> insertColumn(int index, T[] column);

    protected abstract AbstractGenericMatrix<T> removeColumn(int index);

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

    protected abstract boolean isSquare();

    protected abstract boolean isSymmetric();

    protected abstract boolean isIdentity();

    protected abstract boolean isZero();

    protected abstract boolean isUpperTriangular();

    protected abstract boolean isLowerTriangular();

    protected abstract boolean isTriangular();

    protected abstract boolean isDiagonal();

    protected abstract AbstractGenericMatrix<T> copy();
}
