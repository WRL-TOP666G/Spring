package com.example.LuxuryWatch.Service;


import com.example.LuxuryWatch.Beam.Role;
import com.example.LuxuryWatch.Dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public Role saveRole(Role role) {
        return roleDao.save(role);
    }

    public List<Role> getRoles() {
        return roleDao.findAll();
    }
}

