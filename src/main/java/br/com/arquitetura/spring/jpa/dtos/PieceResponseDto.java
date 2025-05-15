package br.com.arquitetura.spring.jpa.dtos;

import java.time.LocalDateTime;

public record PieceResponseDto(
        Long idPiece,
        String name,
        Long idProduct,
        String nameProduct,
        LocalDateTime dateRegistered,
        String userRegistered,
        LocalDateTime dateChanged,
        String userChanged
) {
}
