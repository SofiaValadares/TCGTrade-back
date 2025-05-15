package br.com.arquitetura.spring.jpa.models;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_PIECE", indexes = {@Index(name = "idx_piece_name", columnList = "name")})
public class PieceModel extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPiece;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false)
    private ProductModel productModel;

    @Size(max = 100)
    @Column(length = 100, nullable = false, columnDefinition = "varchar(100)")
    private String name;

    public Long getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(Long idPiece) {
        this.idPiece = idPiece;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public @Size(max = 100) String getName() {
        return name;
    }

    public void setName(@Size(max = 100) String name) {
        this.name = name;
    }
}
