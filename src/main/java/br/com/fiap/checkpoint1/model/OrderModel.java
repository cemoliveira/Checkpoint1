package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do cliente é obrigatório!")
    private String clientName;

    private LocalDate orderDate;

    @DecimalMin(value = "0.0", message = "O valor não pode ser negativo!")
    @Positive
    private BigDecimal totalValue;

    //Behaviors
    @PrePersist
    public void prePersist() {
        if(this.orderDate == null) {
            this.orderDate = LocalDate.now();
        }
    }
}