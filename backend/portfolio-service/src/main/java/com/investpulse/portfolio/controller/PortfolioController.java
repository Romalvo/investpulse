package com.investpulse.portfolio.controller;

import com.investpulse.portfolio.model.InvestmentAsset;
import com.investpulse.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService service;

    @PostMapping("/add")
    public ResponseEntity<InvestmentAsset> addAsset(@RequestBody InvestmentAsset asset, Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        asset.setUserEmail(email);
        return ResponseEntity.ok(service.addAsset(asset));
    }

    @GetMapping
    public ResponseEntity<List<InvestmentAsset>> getPortfolio(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        return ResponseEntity.ok(service.getAssetsForUser(email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsset(@PathVariable Long id) {
        service.deleteAsset(id);
        return ResponseEntity.noContent().build();
    }
}
