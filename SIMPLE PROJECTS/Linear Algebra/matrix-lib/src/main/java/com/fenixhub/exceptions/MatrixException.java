package com.fenixhub.exceptions;

public class MatrixException extends RuntimeException {
    
    public MatrixException() {
        super();
    }

    public MatrixException(String message) {
        super(message);
    }

    public MatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixException(Throwable cause) {
        super(cause);
    }

    protected MatrixException(
        String message, Throwable cause,
        boolean enableSuppression, boolean writableStackTrace) 
    {

        super(message, cause, enableSuppression, writableStackTrace);
    }

}
