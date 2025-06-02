package br.com.arquitetura.spring.jpa.dtos;

import jakarta.validation.constraints.NotNull;

public record CardSearchRecordCollectionNumberDto(
        @NotNull Long collection,
        @NotNull Integer number
) {
}
