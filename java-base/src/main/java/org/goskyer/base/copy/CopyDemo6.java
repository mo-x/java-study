package org.goskyer.base.copy;

/**
 * Created by zzqno on 2017-3-7.
 */
public class CopyDemo6 implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {

        User user = new User();
        user.setAddress(new Address("shanghai"));

        User cpUser = (User) user.clone();
        //注意这里cpUser引用中的Address实例对象是new出来的 与原先user引用中address实例对象已不公用
        cpUser.setAddress(new Address("beijing"));

        System.out.println(user.getAddress() == cpUser.getAddress());
        System.out.println("user address:" + user.getAddress().getCity());
        System.out.println("cpUser address: " + cpUser.getAddress().getCity());

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
