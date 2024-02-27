package com.example.LuxuryWatch.Dao;

import com.example.LuxuryWatch.Beam.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role,Integer> {

    Optional<Role> findByType(String type);
}


