package br.com.arquitetura.spring.jpa.globals.exceptionhandler;

import java.util.Locale;
import org.springframework.context.MessageSource;

public class ResourceBadRequestException extends RuntimeException {
    private final String messageKey;

    public String getMessageKey() {
        return messageKey;
    }

    public ResourceBadRequestException(String message, String messageKey) {
        super(message);
        this.messageKey = messageKey;
    }

    public static ResourceBadRequestException withMessage(MessageSource messageSource, String messageKey, Object[] args, Locale locale) {
        String message = messageSource.getMessage(messageKey, args, locale);
        return new ResourceBadRequestException(message, messageKey);
    }
}