package com.desarrollo.infraestructure.jpa.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order_detail")
@NoArgsConstructor
@Data
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code_order")
    private UUID codeOrder;
    @Column(name = "amount_total")
    private BigDecimal amountTotal;
    @Column(name = "iva")
    private BigDecimal iva;
    @OneToMany(mappedBy = "orderDetail",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<ProductEntity> product;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "fk_id_customer")
    private CustomerEntity customer;


    public void addProduct(ProductEntity productEntity){
        if (productEntity != null){
            if (product == null){
                product = new ArrayList<>();
            }
            product.add(productEntity);
        }
    }


}
