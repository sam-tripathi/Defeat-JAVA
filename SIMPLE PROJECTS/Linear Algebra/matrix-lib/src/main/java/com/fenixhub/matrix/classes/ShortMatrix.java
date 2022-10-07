package com.fenixhub.matrix.classes;

public class ShortMatrix extends GenericMatrix<Short> {

    @Override
    public Class<Short> getClazz() {
        return Short.class;
    }

    @Override
    protected String getFormat() {
        return "%"+formatPaddings+"d";
    }

    public ShortMatrix() {
        super(Short.class);
    }

    public ShortMatrix(int nRows, int nColumns) {
        super(nRows, nColumns, Short.class);
    }

    public ShortMatrix(Short[][] array) {
        super(array);
    }

}
