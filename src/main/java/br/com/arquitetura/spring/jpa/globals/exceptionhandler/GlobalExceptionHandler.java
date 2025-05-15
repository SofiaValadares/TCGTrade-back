package br.com.arquitetura.spring.jpa.globals.exceptionhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String PARAM_TIME = "time";
    private static final String PARAM_ERROR = "error";
    private static final String PARAM_MESSAGE_KEY = "messageKey";
    private static final String PARAM_MESSAGE = "message";

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        logger.error("Validation errors: {}", errors);
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ResourceUnauthorizedException.class)
    public ResponseEntity<Map<String, String>> handleResourceUnauthorizedException(ResourceUnauthorizedException ex) {
        Map<String, String> error = new HashMap<>();
        error.put(PARAM_TIME, String.valueOf(new java.util.Date()));
        error.put(PARAM_ERROR, "Unauthorized access.");
        error.put(PARAM_MESSAGE_KEY, ex.getMessageKey());
        error.put(PARAM_MESSAGE, ex.getMessage());
        logger.error("Unauthorized access: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put(PARAM_TIME, String.valueOf(new java.util.Date()));
        error.put(PARAM_ERROR, "Resource not found.");
        error.put(PARAM_MESSAGE_KEY, ex.getMessageKey());
        error.put(PARAM_MESSAGE, ex.getMessage());
        logger.error("Resource not found: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ResourceFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceFoundException(ResourceFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put(PARAM_TIME, String.valueOf(new java.util.Date()));
        error.put(PARAM_ERROR, "Resource found.");
        error.put(PARAM_MESSAGE_KEY, ex.getMessageKey());
        error.put(PARAM_MESSAGE, ex.getMessage());
        logger.error("Resource found: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.FOUND).body(error);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<Map<String, String>> handleResourceBadRequestException(ResourceBadRequestException ex) {
        Map<String, String> error = new HashMap<>();
        error.put(PARAM_TIME, String.valueOf(new java.util.Date()));
        error.put(PARAM_ERROR, "Bad request");
        error.put(PARAM_MESSAGE_KEY, ex.getMessageKey());
        error.put(PARAM_MESSAGE, ex.getMessage());
        logger.error("Bad request: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put(PARAM_TIME, String.valueOf(new java.util.Date()));
        error.put(PARAM_ERROR, "An unexpected error occurred.");
        error.put(PARAM_MESSAGE_KEY, "erro.general.exception");
        error.put(PARAM_MESSAGE, ex.getMessage());
        logger.error("General exception: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(ResourceBadCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleBadCredentialsException(ResourceBadCredentialsException ex) {
        Map<String, String> error = new HashMap<>();
        error.put(PARAM_TIME, String.valueOf(new java.util.Date()));
        error.put(PARAM_ERROR, "Bad Credentials.");
        error.put(PARAM_MESSAGE_KEY, ex.getMessageKey());
        error.put(PARAM_MESSAGE, ex.getMessage());
        logger.error("Bad Credentials: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(ResourceUsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUsernameNotFoundException(ResourceUsernameNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put(PARAM_TIME, String.valueOf(new java.util.Date()));
        error.put(PARAM_ERROR, "Username Not Found Exception.");
        error.put(PARAM_MESSAGE_KEY, ex.getMessageKey());
        error.put(PARAM_MESSAGE, ex.getMessage());
        logger.error("Username Not Found Exception: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    private String convertMapToJson(Map<String, String> map) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

    public static void handleAuthException(HttpServletResponse response, String message) throws IOException {
        Map<String, String> error = new HashMap<>();
        error.put(PARAM_TIME, String.valueOf(new java.util.Date()));
        error.put(PARAM_ERROR, "IO Exception.");
        error.put(PARAM_MESSAGE_KEY, "erro.token");
        error.put(PARAM_MESSAGE, message);

        GlobalExceptionHandler converter = new GlobalExceptionHandler();
        String json = converter.convertMapToJson(error);

        logger.error("error: {} ", message);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write(json);
        response.getWriter().flush();
    }
}
