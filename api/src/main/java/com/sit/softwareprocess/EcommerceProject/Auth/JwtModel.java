package com.sit.softwareprocess.EcommerceProject.Auth;

public class JwtModel {
    private String token;
    private long exp;

    public JwtModel() {
    }

    public JwtModel(String token, long exp) {
        this.token = token;
        this.exp = exp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }
}
