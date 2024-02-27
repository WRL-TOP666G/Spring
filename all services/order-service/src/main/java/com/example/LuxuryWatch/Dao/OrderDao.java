package com.example.LuxuryWatch.Dao;

import com.example.LuxuryWatch.Beam.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
