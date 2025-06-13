package br.com.arquitetura.spring.jpa.dtos;

import java.time.LocalDateTime;

public record CardResponseDto (
        Long idCard,
        Long idPokemon,
        String name,
        Long collection,
        Integer numberCard,
        LocalDateTime dateRegistered,
        String userRegistered,
        LocalDateTime dateChanged,
        String userChanged
) {

}
