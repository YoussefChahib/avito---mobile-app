package com.esi.avito.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "buyerId", nullable = false)
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "sellerId", nullable = false)
    private User seller;

    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Item item;

}
