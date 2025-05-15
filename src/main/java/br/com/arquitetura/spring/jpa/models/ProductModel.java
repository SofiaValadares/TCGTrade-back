package br.com.arquitetura.spring.jpa.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_PRODUCTS", indexes = {@Index(name = "idx_product_name", columnList = "name")})
public class ProductModel extends AuditModel implements Serializable {
    private static final long serialVersionUID  = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idProduct;

    @Size(max = 100)
    @Column(length = 100, nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @Column(nullable = false, columnDefinition = "Decimal(10,2)")
    private BigDecimal value = BigDecimal.ZERO;

    @Column(nullable = false, columnDefinition = "Decimal(10,2)")
    private BigDecimal tax = BigDecimal.ZERO;

    @OneToMany(mappedBy = "productModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PieceModel> pieceModelList;

    public @Size(max = 100) String getName() {
        return name;
    }

    public void setName(@Size(max = 100) String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
}
