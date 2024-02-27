package com.example.LuxuryWatch.Auth;


import com.example.LuxuryWatch.Beam.User;
import com.example.LuxuryWatch.Dao.RoleDao;
import com.example.LuxuryWatch.Dao.UserDao;
import com.example.LuxuryWatch.Security.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public boolean isTokenValid(String token, User user) {
        return jwtService.isTokenValid(token, user);
    }

    @Transactional
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of(roleDao.findById(2).get()));
        return userDao.save(user);
    }



}

