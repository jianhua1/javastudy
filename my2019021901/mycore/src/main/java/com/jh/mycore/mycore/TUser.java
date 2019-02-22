package com.jh.mycore.mycore;

import javax.persistence.*;

@Entity
@Table(name = "tuser")
public class TUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String userName;
    Integer userAge;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
