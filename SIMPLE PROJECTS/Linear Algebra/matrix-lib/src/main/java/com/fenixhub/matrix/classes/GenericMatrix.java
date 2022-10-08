package com.fenixhub.matrix.classes;

import java.lang.reflect.Array;

import com.fenixhub.exceptions.MatrixSizeException;

@SuppressWarnings("unchecked")
public class GenericMatrix<T extends Number> extends AbstractGenericMatrix<T> {
    
    @Override
    public Class<T> getClazz() {
        return (Class<T>) this.array.getClass().getComponentType().getComponentType();
    }

    @Override
    protected String getFormat() {
        return "%"+formatPaddings+"s";
    }

    public GenericMatrix(Class<T> clazz) {
        super(clazz);
    }

    public GenericMatrix(int nRows, int nColumns, Class<T> clazz) {
        super(nRows, nColumns, clazz);
    }

    public GenericMatrix(T[][] array) {
        super(array);
    }

    public GenericMatrix(AbstractGenericMatrix<T> matrix) {
        super(matrix);
    }

    @Override
    public void setArray(T[][] array) {
        this.array = array;
    }

    @Override
    public T[][] getArrayCopy() {
        return this.array.clone();
    }

    protected T[][] getArrayCopy(int fromRow, int fromColumn, int toRow, int toColumn) {
        if (fromRow < 0 || fromRow > getRows()) {
            throw new IndexOutOfBoundsException(String.format("{fromRow} index is out of bound. Expected 0-%d got %d", getRows(), fromRow));
        }
        if (fromColumn < 0 || fromColumn > getColumns()) {
            throw new IndexOutOfBoundsException(String.format("{fromColumn} index is out of bound. Expected 0-%d got %d", getColumns(), fromColumn));
        }
        if (toRow < 0 || toRow > getRows()) {
            throw new IndexOutOfBoundsException(String.format("{toRow} index is out of bound. Expected 0-%d got %d", getRows(), toRow));
        }
        if (toColumn < 0 || toColumn > getColumns()) {
            throw new IndexOutOfBoundsException(String.format("{toColumn} index is out of bound. Expected 0-%d got %d", getColumns(), fromColumn));
        }
        
        T[][] tempArray = (T[][]) Array.newInstance(getClazz(), toRow - fromRow, toColumn - fromColumn);

        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                tempArray[i][j] = (T) this.array[fromRow + i][fromColumn + j];
            }
        }
        
        return tempArray;
    }


    @Override
    public GenericMatrix<T> setRow(int index, T[] row) {
        if (index < 0 || index >= getRows()) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }
        if (row.length != getColumns()) {
            throw new MatrixSizeException("row length", row.length, getColumns());
        }
        this.array[index] = row;
        return this;
    }

    @Override
    public GenericMatrix<T> insertRow(int index, T[] row) {
        if (index < 0 || index > getRows()) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }
        if (row.length != getColumns()) {
            throw new MatrixSizeException("row length", row.length, getColumns());
        }

        T[][] tempArray = (T[][]) Array.newInstance(getClazz(), getRows() + 1, getColumns());
        for (int i = 0; i < tempArray.length; i++) {
            if (i < index) {
                tempArray[i] = this.array[i];
            } else if (i == index) {
                tempArray[i] = row;
            } else {
                tempArray[i] = this.array[i - 1];
            }
        }
        
        setArray(tempArray);
        return this;
    }

    @Override
    public GenericMatrix<T> removeRow(int index) {
        if (index < 0 || index >= getRows()) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }

        T[][] tempArray = (T[][]) Array.newInstance(getClazz(), getRows() - 1, getColumns());
        for (int i = 0; i < tempArray.length; i++) {
            if (i < index) {
                tempArray[i] = this.array[i];
            } else {
                tempArray[i] = this.array[i + 1];
            }
        }

        setArray(tempArray);
        return this;
    }

    @Override
    public GenericMatrix<T> setColumn(int index, T[] column) {
        if (index < 0 || index >= getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }
        if (column.length != getRows()) {
            throw new MatrixSizeException("column length", column.length, getRows());
        }
        for (int i = 0; i < getRows(); i++) {
            this.array[i][index] = column[i];
        }
        return this;
    }

    @Override
    public GenericMatrix<T> insertColumn(int index, T[] column) {
        if (index < 0 || index > getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }
        if (column.length != getRows()) {
            throw new MatrixSizeException("column length", column.length, getRows());
        }

        T[][] tempArray = (T[][]) Array.newInstance(getClazz(), getRows(), getColumns() + 1);
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                if (j < index) {
                    tempArray[i][j] = this.array[i][j];
                } else if (j == index) {
                    tempArray[i][j] = column[i];
                } else {
                    tempArray[i][j] = this.array[i][j - 1];
                }
            }
        }

        setArray(tempArray);
        return this;
    }

    @Override
    public GenericMatrix<T> removeColumn(int index) {
        if (index < 0 || index >= getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }

        T[][] tempArray = (T[][]) Array.newInstance(getClazz(), getRows(), getColumns() - 1);
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                if (j < index) {
                    tempArray[i][j] = this.array[i][j];
                } else {
                    tempArray[i][j] = this.array[i][j + 1];
                }
            }
        }

        setArray(tempArray);
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
        this.array[row][column] = value;
        return this;
    }

    @Override
    public T[] getRow(int index) {
        if (index < 0 || index >= getRows()) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }
        return this.array[index];
    }

    @Override
    public int getRows() {
        return this.array.length;
    }

    @Override
    public T[] getColumn(int index) {
        if (index < 0 || index >= getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }
        T[] column = (T[]) Array.newInstance(getClazz(), getRows());
        for (int i = 0; i < getRows(); i++) {
            column[i] = this.array[i][index];
        }
        return column;
    }

    @Override
    public int getColumns() {
        return this.array[0].length;
    }

    @Override
    public T get(int row, int column) {
        if (row < 0 || row >= getRows()) {
            throw new IndexOutOfBoundsException("Row index is out of bound.");
        }
        if (column < 0 || column >= getColumns()) {
            throw new IndexOutOfBoundsException("Column index is out of bound.");
        }
        return this.array[row][column];
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
        setArray(getArrayCopy(fromRow, fromColumn, toRow, toColumn));
        return this;
    }

    @Override
    public boolean isSquare() {
        return getRows() == getColumns();
    }

    @Override
    public boolean isSymmetric() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (!this.array[i][j].equals(this.array[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isDiagonal() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (i != j && get(i, j).doubleValue()!=(0.0)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isIdentity() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (i == j && get(i, j).doubleValue()!=(1.)) {
                    return false;
                } else if (i != j && get(i, j).doubleValue()!=(0.)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isUpperTriangular() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (i > j && get(i, j).doubleValue()!=(0.0)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isLowerTriangular() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (i < j && get(i, j).doubleValue()!=(0.0)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isTriangular() {
        return isUpperTriangular() || isLowerTriangular();
    }

    @Override
    public boolean isZero() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (get(i, j).doubleValue()!=(0.0)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override 
    public GenericMatrix<T> copy() {
        return new GenericMatrix<T>(getArrayCopy());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                sb.append(String.format(getFormat(), this.array[i][j])).append(" ");
            }
            sb.append("\r\n");
        }
        return "\r\n"+sb.toString();
    }

}
