package com.investpulse.portfolio.service.impl;

import com.investpulse.portfolio.model.InvestmentAsset;
import com.investpulse.portfolio.repository.InvestmentAssetRepository;
import com.investpulse.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final InvestmentAssetRepository repo;

    @Override
    public InvestmentAsset addAsset(InvestmentAsset asset) {
        return repo.save(asset);
    }

    @Override
    public List<InvestmentAsset> getAssetsForUser(String userEmail) {
        return repo.findByUserEmail(userEmail);
    }

    @Override
    public void deleteAsset(Long id) {
        repo.deleteById(id);
    }
}
