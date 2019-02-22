package com.jh.myproject2019021501.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tuser")
public class TUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    String userName;
    Integer userAge;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
