package br.com.arquitetura.spring.jpa.globals.exceptionhandler;

public class ResourceJsonProcessingRuntimeException extends RuntimeException {
    public ResourceJsonProcessingRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}