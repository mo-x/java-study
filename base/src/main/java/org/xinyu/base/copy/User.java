package org.xinyu.base.copy;

import java.io.Serializable;

/**
 * Created by zzqno on 2017-3-6.
 */
public class User implements Cloneable,Serializable {
    public Address address;
    String name;

    public User() {
    }

    public User(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone()  {
        User user = null;
        try {
            user = (User) super.clone();
            /**
             * 注意这里
             * 若在拷贝user 对象 则起Address 是新的实例对象
             * 来保证修改copy后的对象的修改不会引起原有对象的内容的变化
             */
           /* user.setAddress(new Address());*/
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
