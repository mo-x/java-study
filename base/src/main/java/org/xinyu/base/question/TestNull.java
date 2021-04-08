package org.xinyu.base.question;

/**
 * @author  zhiqing.zhang
 */
public class TestNull {

    private Integer age;

    private String name;


    /**
     * 此处使用基本类型返回 会抛出 java.lang.NullPointerException
     * 使用包装类型则不会抛出异常 对象类型默认为null
     * @return
     */
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TestNull testNull = new TestNull();
        System.out.println(testNull.getAge());
        System.out.println(testNull.getName());

    }
}
