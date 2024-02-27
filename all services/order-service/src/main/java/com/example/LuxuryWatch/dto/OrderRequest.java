package com.example.LuxuryWatch.dto;

import com.example.LuxuryWatch.Beam.Purchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<Purchase> purchaseDtoList;
}