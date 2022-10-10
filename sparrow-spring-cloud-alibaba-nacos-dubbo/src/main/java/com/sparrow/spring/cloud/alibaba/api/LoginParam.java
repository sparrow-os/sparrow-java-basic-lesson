//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.sparrow.spring.cloud.alibaba.api;

public class LoginParam {
    private String userName;
    private String password;

    public LoginParam() {
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "LoginParam{userName='" + this.userName + '\'' + ", password='" + this.password + '\'' + '}';
    }
}
