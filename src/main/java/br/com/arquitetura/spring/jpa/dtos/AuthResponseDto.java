package br.com.arquitetura.spring.jpa.dtos;

public record AuthResponseDto(
        String jwt,
        Boolean ok,
        UserRoleResponseDto user
) {
}
