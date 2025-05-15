package br.com.arquitetura.spring.jpa.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseDto(
        Long idProduct,
        String name,
        BigDecimal value,
        BigDecimal tax,
        LocalDateTime dateRegistered,
        String userRegistered,
        LocalDateTime dateChanged,
        String userChanged
) {
}
