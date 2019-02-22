package com.jh.mycore.myservice;

import com.jh.mycore.mycore.TUser;
import com.jh.mycore.mydao.TUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserService {
    @Autowired
    TUserDao tUserDao;

    public List<TUser> findAllByUserAge(Integer userAge) {
        return tUserDao.findAllByUserAge(userAge);
    }


}
