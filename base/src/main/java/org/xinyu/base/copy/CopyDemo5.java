package org.xinyu.base.copy;

/**
 * Created by zzqno on 2017-3-6.
 */
public class CopyDemo5 {
    public static void main(String[] args) {
        User user = new User();
        user.setAddress(new Address("beijing"));

        User cpUser = CloneUtils.clone(user);

        cpUser.setAddress(new Address("shanghai"));

        System.out.println("user: "+user.getAddress().getCity());
        System.out.println("cpUser: "+cpUser.getAddress().getCity());


    }
}
