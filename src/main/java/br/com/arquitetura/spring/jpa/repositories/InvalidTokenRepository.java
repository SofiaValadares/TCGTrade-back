package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.InvalidTokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface InvalidTokenRepository extends JpaRepository<InvalidTokenModel, Long> {

    boolean existsByToken(String token);

    @Modifying
    @Transactional
    @Query("DELETE FROM InvalidTokenModel t WHERE t.expirationTime < :currentTime")
    void deleteExpiredTokens(@Param("currentTime") LocalDateTime currentTime);
}