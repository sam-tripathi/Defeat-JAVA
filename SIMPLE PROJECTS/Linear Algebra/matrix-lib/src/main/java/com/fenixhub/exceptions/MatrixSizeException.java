package com.fenixhub.exceptions;

public class MatrixSizeException extends MatrixException {

    public MatrixSizeException() {
        super("Matrix size is not valid");
    }

    public MatrixSizeException(String dimension, int wrongDimension, int expectedDimension) {
        super(String.format("{%s} size is not valid. Expected size {%d}, got {%d}", dimension, expectedDimension, wrongDimension));
    }

    public MatrixSizeException(String message) {
        super(message);
    }

    public MatrixSizeException(String message, Throwable cause) {
        super(message, cause);
    }

}
