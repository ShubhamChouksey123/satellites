package com.shubham.app.exception;

public class InvalidParameters extends Exception {

    private static final long serialVersionUID = 1L;
    private static final String ERROR_MESSAGE_DEFAULT = "Unable to complete request, please try again later";

    public InvalidParameters(String message) {
        super(message);
    }

    public InvalidParameters() {
        super(ERROR_MESSAGE_DEFAULT);
    }
}
