package com.investpulse.portfolio.repository;

import com.investpulse.portfolio.model.InvestmentAsset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentAssetRepository extends JpaRepository<InvestmentAsset, Long> {
    List<InvestmentAsset> findByUserEmail(String userEmail);
}
