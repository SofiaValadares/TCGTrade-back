package br.com.arquitetura.spring.jpa.scheduler;

import br.com.arquitetura.spring.jpa.repositories.InvalidTokenRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Component
public class TokenCleanupScheduler {

    private final InvalidTokenRepository invalidTokenRepository;

    public TokenCleanupScheduler(InvalidTokenRepository invalidTokenRepository) {
        this.invalidTokenRepository = invalidTokenRepository;
    }

    // Executa diariamente à meia-noite
    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void cleanupExpiredTokens() {
        invalidTokenRepository.deleteExpiredTokens(LocalDateTime.now());
    }
}