package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.PieceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PieceRepository extends JpaRepository<PieceModel, Long> {

    Page<PieceModel> findAll(Specification<PieceModel> spec, Pageable pageable);

    List<PieceModel> findByProductModelIdProduct(Long idProduct);
}
