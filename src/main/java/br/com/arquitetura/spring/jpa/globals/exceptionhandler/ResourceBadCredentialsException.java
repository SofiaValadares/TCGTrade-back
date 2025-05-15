package br.com.arquitetura.spring.jpa.globals.exceptionhandler;

import java.util.Locale;
import org.springframework.context.MessageSource;

public class ResourceBadCredentialsException extends RuntimeException {
    private final String messageKey;

    public String getMessageKey() {
        return messageKey;
    }

    public ResourceBadCredentialsException(String message, String messageKey) {
        super(message);
        this.messageKey = messageKey;
    }

    public static ResourceBadCredentialsException withMessage(MessageSource messageSource, String messageKey, Object[] args, Locale locale) {
        String message = messageSource.getMessage(messageKey, args, locale);
        return new ResourceBadCredentialsException(message, messageKey);
    }
}