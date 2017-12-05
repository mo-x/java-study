package org.goskyer.base.copy;

/**
 * Created by zzqno on 2017-3-6.
 * 若变量为 String 字符串，则拷贝其地址引用。
 * 但是在修改时，它会从字符串池中重新生成一个新的字符串，原有对象保持不变。
 */
public class CopyDemo2 {

    public static void main(String[] args) {
        Address address = new Address();
        address.setCity("shanghai");

        Address cpAddress = (Address) address.clone();
        cpAddress.setCity("beijing");

        System.out.println(address == cpAddress);
        System.out.println(address.getCity());
        System.out.println(cpAddress.getCity());

    }

}
