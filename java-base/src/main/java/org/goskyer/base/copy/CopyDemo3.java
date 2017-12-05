package org.goskyer.base.copy;

/**
 * Created by zzqno on 2017-3-6.
 * 对象中包含了另一个对象
 * 如果变量是一个实例对象，则拷贝其地址引用，也就是说此时新对象与原来对象是公用该实例变量。
 */
public class CopyDemo3 {

    public static void main(String[] args) {
        User user = new User();
        user.setName("hello");

        Address address = new Address("shanghai");
        user.setAddress(address);

        User cpUser = (User) user.clone();
        //cpUser.setAddress(new Address("shengzhen"));
        cpUser.getAddress().setCity("beijing");


        System.out.println(address == cpUser.getAddress()); //true
        System.out.println("user address:"+user.getAddress().getCity());//beijing
        System.out.println("copy user address:"+cpUser.getAddress().getCity());//beijing
    }
}
