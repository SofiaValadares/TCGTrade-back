package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.PieceModel;
import br.com.arquitetura.spring.jpa.repositories.PieceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PieceServiceImpl implements PieceService {

    private final PieceRepository pieceRepository;

    public PieceServiceImpl(PieceRepository pieceRepository) {
        this.pieceRepository = pieceRepository;
    }

    @Override
    public List<PieceModel> findByProductModelIdProduct(Long idProduct) {
        return pieceRepository.findByProductModelIdProduct(idProduct);
    }

    @Override
    public Optional<PieceModel> getOnePiece(Long id) {
        return pieceRepository.findById(id);
    }

    @Override
    public PieceModel savePiece(PieceModel pieceModel) {
        return pieceRepository.save(pieceModel);
    }

    @Override
    public PieceModel updatePiece(PieceModel pieceModel) {
        return pieceRepository.save(pieceModel);
    }

    @Override
    public void deletePiece(PieceModel pieceModel) {
        pieceRepository.delete(pieceModel);
    }

    @Override
    public Page<PieceModel> getAllPagePieces(Specification<PieceModel> spec, Pageable pageable) {
        return pieceRepository.findAll(spec, pageable);
    }
}
