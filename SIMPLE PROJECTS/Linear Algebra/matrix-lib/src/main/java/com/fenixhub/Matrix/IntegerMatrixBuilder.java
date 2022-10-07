package com.fenixhub.Matrix;

public class IntegerMatrixBuilder implements GenericMatrixBuilder<Integer> {

    IntegerMatrix matrix;

    public IntegerMatrixBuilder() {
    }

    public IntegerMatrixBuilder ofSize(int nRows, int nColumns) {
        matrix = new IntegerMatrix(nRows, nColumns);
        return this;
    }

    @Override
    public IntegerMatrixBuilder fromArray(Integer[][] array) {
        matrix = new IntegerMatrix(array);
        return this;
    }

    @Override
    public IntegerMatrixBuilder ofRandom(int nRows, int nColumns, Integer min, Integer max) {
        matrix = new IntegerMatrix(new Integer[nRows][nColumns]);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                matrix.set(i, j, min + generator.nextInt(max - min));
            }
        }
        return this;
    }

    @Override
    public IntegerMatrixBuilder ofRandom(int nRows, int nColumns) {
        return ofRandom(nRows, nColumns, 0, 1);
    }

    @Override
    public IntegerMatrix build() {
        return matrix;
    }
    
}
