package com.fenixhub.exceptions;

public class MatrixSizeException extends RuntimeException {

    public MatrixSizeException() {
        super("Matrix size is not valid");
    }

    public MatrixSizeException(String message) {
        super(message);
    }

    public MatrixSizeException(String message, Throwable cause) {
        super(message, cause);
    }

}
