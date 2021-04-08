package org.xinyu.jvm.init.demo1;

/**
 * 测试被动初始化演示代码
 * 运行时添加 -XX:+TraceClassLoading 监控类的加载
 *
 * @description:
 * @author: monster_x
 * @create: 2018-09-02 01:02
 **/
public class TestParentLoading {
    public static void main(String[] args) {
        //1.此处引用父类的静态字段 是不会触发子类的初始化

        System.out.println(SubClass.value); //invokespecial 调用特殊实例方法 包括实例初始化方法、父类方法
        //2.此处不会触发类的初始化
        SuperClass[] sca = new SuperClass[10];//anewarray 创建数组指令
    }
}
