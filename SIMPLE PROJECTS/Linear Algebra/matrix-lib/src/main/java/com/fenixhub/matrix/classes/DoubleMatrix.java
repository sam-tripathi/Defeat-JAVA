package com.fenixhub.matrix.classes;

public class DoubleMatrix extends GenericMatrix<Double> {

    @Override
    public Class<Double> getClazz() {
        return Double.class;
    }

    @Override
    protected String getFormat() {
        return "%"+formatPaddings+"g";
    }

    public DoubleMatrix() {
        super(Double.class);
    }

    public DoubleMatrix(int nRows, int nColumns) {
        super(nRows, nColumns, Double.class);
    }

    public DoubleMatrix(Double[][] array) {
        super(array);
    }

    public DoubleMatrix(GenericMatrix<Double> matrix) {
        super(matrix);
    }

}
