package com.investpulse.portfolio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "assets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String assetType;

    @Column(nullable = false)
    private String symbol;

    @Column(nullable = false)
    private Double quantity;

    private Double buyPrice;

    private Instant createdAt = Instant.now();
}
