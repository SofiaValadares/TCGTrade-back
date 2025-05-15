package br.com.arquitetura.spring.jpa.dtos;

public record ActivateRecordDto(
        String cpf,
        String email,
        String telefone,
        String senha
) {
}
