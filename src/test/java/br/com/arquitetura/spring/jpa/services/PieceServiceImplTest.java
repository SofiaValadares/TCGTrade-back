package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.PieceModel;
import br.com.arquitetura.spring.jpa.repositories.PieceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PieceServiceImplTest {

    @InjectMocks
    private PieceServiceImpl pieceService;

    @Mock
    private PieceRepository pieceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByProductModelIdProduct() {
        // Given
        Long idProduct = 1L;
        PieceModel piece1 = new PieceModel();
        piece1.setIdPiece(1L);
        piece1.setName("Piece 1");

        PieceModel piece2 = new PieceModel();
        piece2.setIdPiece(2L);
        piece2.setName("Piece 2");

        List<PieceModel> pieces = List.of(piece1, piece2);
        when(pieceRepository.findByProductModelIdProduct(idProduct)).thenReturn(pieces);

        // When
        List<PieceModel> result = pieceService.findByProductModelIdProduct(idProduct);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Piece 1", result.get(0).getName());
        verify(pieceRepository, times(1)).findByProductModelIdProduct(idProduct);
    }

    @Test
    void testGetOnePiece_Found() {
        // Given
        Long id = 1L;
        PieceModel piece = new PieceModel();
        piece.setIdPiece(id);
        piece.setName("Test Piece");

        when(pieceRepository.findById(id)).thenReturn(Optional.of(piece));

        // When
        Optional<PieceModel> result = pieceService.getOnePiece(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Test Piece", result.get().getName());
        verify(pieceRepository, times(1)).findById(id);
    }

    @Test
    void testGetOnePiece_NotFound() {
        // Given
        Long id = 1L;

        when(pieceRepository.findById(id)).thenReturn(Optional.empty());

        // When
        Optional<PieceModel> result = pieceService.getOnePiece(id);

        // Then
        assertFalse(result.isPresent());
        verify(pieceRepository, times(1)).findById(id);
    }

    @Test
    void testSavePiece() {
        // Given
        PieceModel piece = new PieceModel();
        piece.setIdPiece(1L);
        piece.setName("New Piece");

        when(pieceRepository.save(any(PieceModel.class))).thenReturn(piece);

        // When
        PieceModel result = pieceService.savePiece(piece);

        // Then
        assertNotNull(result);
        assertEquals("New Piece", result.getName());
        verify(pieceRepository, times(1)).save(piece);
    }

    @Test
    void testUpdatePiece() {
        // Given
        PieceModel piece = new PieceModel();
        piece.setIdPiece(1L);
        piece.setName("Updated Piece");

        when(pieceRepository.save(any(PieceModel.class))).thenReturn(piece);

        // When
        PieceModel result = pieceService.updatePiece(piece);

        // Then
        assertNotNull(result);
        assertEquals("Updated Piece", result.getName());
        verify(pieceRepository, times(1)).save(piece);
    }

    @Test
    void testDeletePiece() {
        // Given
        PieceModel piece = new PieceModel();
        piece.setIdPiece(1L);

        doNothing().when(pieceRepository).delete(piece);

        // When
        pieceService.deletePiece(piece);

        // Then
        verify(pieceRepository, times(1)).delete(piece);
    }

    @Test
    void testGetAllPagePieces() {
        // Given
        PieceModel piece1 = new PieceModel();
        piece1.setIdPiece(1L);
        piece1.setName("Piece 1");

        PieceModel piece2 = new PieceModel();
        piece2.setIdPiece(2L);
        piece2.setName("Piece 2");

        Page<PieceModel> page = new PageImpl<>(Arrays.asList(piece1, piece2));

        Pageable pageable = PageRequest.of(0, 10);
        Specification<PieceModel> spec = mock(Specification.class);

        when(pieceRepository.findAll(spec, pageable)).thenReturn(page);

        Page<PieceModel> result = pieceService.getAllPagePieces(spec, pageable);

        assertNotNull(result);
        assertEquals(2, result.getTotalElements());
        assertEquals("Piece 1", result.getContent().get(0).getName());
        assertEquals("Piece 2", result.getContent().get(1).getName());

        verify(pieceRepository, times(1)).findAll(spec, pageable);
    }
}
