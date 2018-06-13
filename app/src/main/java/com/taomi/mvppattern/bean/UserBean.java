package com.taomi.mvppattern.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by LBT on 2018/5/25.
 */
public class UserBean implements Serializable {
    private static final long serialVersionUID = -6681915081277078034L;
    private String token;

    private String nickName;

    private String sex;

    private String mblNo;

    private String telNo;

    private String avatar;
    //是否实名认证，0：未认证，1：待审核，2：已经认证，3：认证失败
    private String isAuth;

    //是否设置提现密码，0：没有，1：有
    private String isLogpwd;
    //是否设置提现密码，0：没有，1：有
    private String isPaypwd;

    private BigDecimal balance;

    private BigDecimal reward;

    private int couponNum;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMblNo() {
        return mblNo;
    }

    public void setMblNo(String mblNo) {
        this.mblNo = mblNo;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
    }

    public String getIsPaypwd() {
        return isPaypwd;
    }

    public void setIsPaypwd(String isPaypwd) {
        this.isPaypwd = isPaypwd;
    }

    public String getIsLogpwd() {
        return isLogpwd;
    }

    public void setIsLogpwd(String isLogpwd) {
        this.isLogpwd = isLogpwd;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public int getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(int couponNum) {
        this.couponNum = couponNum;
    }
}
