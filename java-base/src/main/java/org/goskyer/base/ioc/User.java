package org.goskyer.base.ioc;

/**
 * Created by zzqno on 2016-12-25.
 */
public class User {

    private Integer userID;
    private String userName;

    public User() {
    }

    public Integer getUserID() {
        System.out.println("User:getUserID");
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        System.out.println("User:getUserName");
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
