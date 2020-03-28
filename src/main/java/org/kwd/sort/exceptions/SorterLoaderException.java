package org.kwd.sort.exceptions;

public class SorterLoaderException extends Exception {

    private String message;

    public SorterLoaderException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
