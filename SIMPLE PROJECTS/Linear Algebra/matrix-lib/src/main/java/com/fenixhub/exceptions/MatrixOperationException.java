package com.fenixhub.exceptions;

import java.util.Arrays;

import com.fenixhub.matrix.classes.GenericMatrix;

public class MatrixOperationException extends MatrixException {

    public MatrixOperationException() {
        super("Matrix operation is not valid");
    }

    public MatrixOperationException(String message) {
        super(message);
    }

    public <T extends Number> MatrixOperationException(GenericMatrix<T> a, GenericMatrix<T> b) {
        super(String.format("Matrix operation is not valid. Matrix A {%s} and B {%s} are not compatible", Arrays.toString(a.getSize()), Arrays.toString(b.getSize())));
    }

    public MatrixOperationException(String message, Throwable cause) {
        super(message, cause);
    }

}
