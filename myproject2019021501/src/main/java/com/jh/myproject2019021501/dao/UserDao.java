package com.jh.myproject2019021501.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<TUser,Integer> {
      @CacheEvict
      TUser findByUserAge(int age);
}
