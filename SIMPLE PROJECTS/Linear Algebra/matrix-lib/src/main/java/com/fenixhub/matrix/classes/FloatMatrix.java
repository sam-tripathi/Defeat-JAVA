package com.fenixhub.matrix.classes;

public class FloatMatrix extends GenericMatrix<Float> {

    @Override
    public Class<Float> getClazz() {
        return Float.class;
    }

    @Override
    protected String getFormat() {
        return "%"+formatPaddings+"g";
    }

    public FloatMatrix() {
        super(Float.class);
    }

    public FloatMatrix(int nRows, int nColumns) {
        super(nRows, nColumns, Float.class);
    }

    public FloatMatrix(Float[][] array) {
        super(array);
    }

}
