package com.example.LuxuryWatch.Dao;

import com.example.LuxuryWatch.Beam.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDao extends JpaRepository<Purchase,Integer> {
}
