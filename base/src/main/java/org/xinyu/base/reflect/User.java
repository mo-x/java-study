package org.xinyu.base.reflect;

/**
 * Created by monster_zzq on 2016/7/18.
 */
public class User {

    private int id;
    private String username;
    private String age;

    public User(){

    }

    public User(int id, String age, String username) {
        this.id = id;
        this.age = age;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
