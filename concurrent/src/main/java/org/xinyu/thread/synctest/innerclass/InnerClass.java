package org.xinyu.thread.synctest.innerclass;

/**
 * Created by zzqno on 2017-6-3.
 */
public class InnerClass {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



     class privateClass {
        private String age;
        private String address;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static void main(String[] args) {
        InnerClass publicClass = new InnerClass();
        publicClass.setPassword("passwordValue");
        publicClass.setUsername("usernameValue");
        System.out.println(publicClass.getUsername() +" " + publicClass.getPassword());
        privateClass privateClass = publicClass.new privateClass();
        privateClass.setAddress("addressValue");
        privateClass.setAge("ageValue");

    }

}
