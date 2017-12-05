package org.goskyer.base.copy;

import java.io.Serializable;

/**
 * Created by zzqno on 2017-3-6.
 * 实现拷贝 必须实现Cloneable 重写clone方法
 */
public class Address implements Cloneable,Serializable{

    String city;

    public Address() {
    }

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Object clone()  {
        Address address = null;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }

    public static void main(String[] args) {
        Address address = (Address) new Address().clone();
    }
}
