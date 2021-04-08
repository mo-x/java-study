package org.xinyu.base.question;

/**
 * Created by zzqno on 2017-5-8.
 */
public class Value {

    public int x = 10;

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(20);

        System.out.println(userInfo.getAge());
        System.out.println(userInfo);
        new Value().getUserInfo(userInfo);
        System.out.println(userInfo);
        System.out.println(userInfo.getAge());


      /*  Value value = new Value();
        System.out.println(value.x);
        value.changeValue(value.x);
        System.out.println(value.x);*/
    }

    public void changeValue(int x) {
        x = 11;
    }

    public void getUserInfo(UserInfo userInfo) {
        System.out.println(userInfo);
        userInfo = new UserInfo();
        userInfo.setAge(11);
        System.out.println("update :"+ userInfo);
    }

    static class UserInfo {
        private String name;
        private int age = 12;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
