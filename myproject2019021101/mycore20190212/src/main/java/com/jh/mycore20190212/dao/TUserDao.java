package com.jh.mycore20190212.dao;

import com.jh.mycore20190212.core.TUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TUserDao extends JpaRepository<TUser,Integer> {

    List<TUser> findAllByUserId(Integer userId);
}
