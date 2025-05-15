package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.PieceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface PieceService {

    List<PieceModel> findByProductModelIdProduct(Long idProduct);

    Optional<PieceModel> getOnePiece(Long id);

    PieceModel savePiece(PieceModel pieceModel);

    PieceModel updatePiece(PieceModel pieceModel);

    void deletePiece(PieceModel pieceModel);

    Page<PieceModel> getAllPagePieces(Specification<PieceModel> spec, Pageable pageable);

}
