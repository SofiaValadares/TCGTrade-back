package br.com.arquitetura.spring.jpa.dtos;

public record UserResponseDto(
        Long idUser,
        String name,
        String email,
        String username,
        Boolean accountNonExpired,
        Boolean accountNonLocked,
        Boolean credentialsNonExpired,
        Boolean enabled,
        String telefone
) {
}
