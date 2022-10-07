package com.fenixhub.matrix.classes;

public class IntegerMatrix extends GenericMatrix<Integer> {

    @Override
    public Class<Integer> getClazz() {
        return Integer.class;
    }

    @Override
    protected String getFormat() {
        return "%"+formatPaddings+"d";
    }

    public IntegerMatrix() {
        super(Integer.class);
    }

    public IntegerMatrix(int nRows, int nColumns) {
        super(nRows, nColumns, Integer.class);
    }

    public IntegerMatrix(Integer[][] array) {
        super(array);
    }

    public IntegerMatrix(GenericMatrix<Integer> matrix) {
        super(matrix);
    }

}
