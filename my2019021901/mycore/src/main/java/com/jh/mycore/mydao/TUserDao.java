package com.jh.mycore.mydao;

import com.jh.mycore.mycore.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TUserDao extends JpaRepository<TUser,Integer> {

     List<TUser> findAllByUserAge(Integer userAge);
}
