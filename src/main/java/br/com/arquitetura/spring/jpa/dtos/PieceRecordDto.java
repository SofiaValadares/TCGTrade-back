package br.com.arquitetura.spring.jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PieceRecordDto(
        @NotNull(message = "Product id cannot be null.") Long idProduct,
        @NotNull(message = "Piece name cannot be null.") @NotBlank(message = "Piece name cannot be blank.") String name
) {
}

