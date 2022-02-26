package br.com.mateus.csvhandler.endpoint.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String string) {
        super(string);
    }

}
