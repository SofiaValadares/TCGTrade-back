package br.com.arquitetura.spring.jpa.globals.exceptionhandler;
import java.util.Locale;
import org.springframework.context.MessageSource;

public class ResourceUnauthorizedException extends RuntimeException {
    private final String messageKey;

    public ResourceUnauthorizedException(String message, String messageKey) {
        super(message);
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }
    public static ResourceUnauthorizedException withMessage(MessageSource messageSource, String messageKey, Object[] args, Locale locale) {
        String message = messageSource.getMessage(messageKey, args, locale);
        return new ResourceUnauthorizedException(message, messageKey);
    }
}