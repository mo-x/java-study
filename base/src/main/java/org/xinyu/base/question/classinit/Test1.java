package org.xinyu.base.question.classinit;

/**
 * Created by zzq on 16-10-26.
 */


class InitClass1 {
    static {
        System.out.println("初始化InitClass");
    }

    public InitClass1() {
        System.out.println("初始化InitClass1 构造器");
    }

    public static String a = null;

    public static void method() {
    }
}

class SubInitClass1 extends InitClass1 {

}


public class Test1 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //  主动引用引起类的初始化一: new对象、读取或设置类的静态变量、调用类的静态方法。
        //new InitClass1();
        //  InitClass1.a = "";
        //String a = InitClass1.a;
        // InitClass1.method();

        //  主动引用引起类的初始化二：通过反射实例化对象、读取或设置类的静态变量、调用类的静态方法。
//        Class cls = InitClass1.class;
//        cls.newInstance();

        //  f.get(null);
        //  f.set(null, "s");

        //  Method md = cls.getDeclaredMethod("method");
        //  md.invoke(null, null);

        //  主动引用引起类的初始化三：实例化子类，引起父类初始化。
        //  new SubInitClass();
    }


}
