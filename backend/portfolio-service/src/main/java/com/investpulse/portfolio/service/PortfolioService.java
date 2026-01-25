package com.investpulse.portfolio.service;

import com.investpulse.portfolio.model.InvestmentAsset;

import java.util.List;

public interface PortfolioService {
    InvestmentAsset addAsset(InvestmentAsset asset);
    List<InvestmentAsset> getAssetsForUser(String userEmail);
        void deleteAsset(Long id);
}
