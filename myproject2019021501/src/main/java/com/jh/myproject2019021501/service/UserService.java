package com.jh.myproject2019021501.service;

import com.jh.myproject2019021501.dao.TUser;
import com.jh.myproject2019021501.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public TUser getUser(){
       return userDao.findByUserAge(11);
    }
}
