package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.GenerationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenerationRepository extends JpaRepository<GenerationModel, Long> {
    List<GenerationModel> findAllByOrderByNumberAsc();
    Optional<GenerationModel> findByIdGeneration(Long idGeneration);
    Optional<GenerationModel> findByNumber(Integer number);

    boolean existsByNumber(Integer number);
}
