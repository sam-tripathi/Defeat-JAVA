package com.fenixhub.Matrix;

public class IntegerMatrix extends GenericMatrix<Integer> {

    @Override
    protected Class<Integer> getClazz() {
        return Integer.class;
    }

    public IntegerMatrix() {
        super();
    }

    public IntegerMatrix(int nRows, int nColumns) {
        super(nRows, nColumns);
    }

    public IntegerMatrix(Integer[][] array) {
        super(array);
    }

}
