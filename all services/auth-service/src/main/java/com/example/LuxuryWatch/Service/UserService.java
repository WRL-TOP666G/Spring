package com.example.LuxuryWatch.Service;


import com.example.LuxuryWatch.Beam.User;
import com.example.LuxuryWatch.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    public List<User> getAll() {
        return userDao.findAll();
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

}
