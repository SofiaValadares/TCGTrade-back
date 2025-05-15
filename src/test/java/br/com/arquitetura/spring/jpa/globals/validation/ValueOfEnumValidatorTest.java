package br.com.arquitetura.spring.jpa.globals.validation;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

enum TestEnum {
    VALUE_ONE,
    VALUE_TWO,
    VALUE_THREE
}

class ValueOfEnumValidatorTest {

    private ValueOfEnumValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new ValueOfEnumValidator();

        // Inicializar o validador com a enumeração TestEnum
        validator.initialize(new ValueOfEnum() {
            @Override
            public Class<? extends Enum<?>> enumClass() {
                return TestEnum.class;  // Retorna a enumeração de teste
            }

            @Override
            public String message() {
                return "";
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return (Class<? extends Annotation>) ValueOfEnum.class;
            }
        });
    }

    @Test
    void testIsValid_WhenValueIsValidEnum() {
        // Testar com valores válidos
        assertTrue(validator.isValid("VALUE_ONE", mock(ConstraintValidatorContext.class)));
        assertTrue(validator.isValid("VALUE_TWO", mock(ConstraintValidatorContext.class)));
        assertTrue(validator.isValid("VALUE_THREE", mock(ConstraintValidatorContext.class)));
    }

    @Test
    void testIsValid_WhenValueIsInvalidEnum() {
        // Testar com valores inválidos
        assertFalse(validator.isValid("INVALID_VALUE", mock(ConstraintValidatorContext.class)));
        assertFalse(validator.isValid("ANOTHER_INVALID", mock(ConstraintValidatorContext.class)));
    }

    @Test
    void testIsValid_WhenValueIsNull() {
        // Testar valor nulo (deve ser considerado válido)
        assertTrue(validator.isValid(null, mock(ConstraintValidatorContext.class)));
    }
}
