package org.goskyer.base.lambda;


import java.util.function.Supplier;

class People {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        System.out.println("toString invoked");

        // 假设一些耗时方法
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "User [name=" + name + "]";
    }

}

class MyLog {

    public void debug(String s) {
        if (isDebug()) {
            doPrint(s);
        }
    }

    public void debug(Supplier<String> s) {
        if (isDebug()) {
            doPrint(s.get());
        }
    }

    private void doPrint(String s) {
        System.out.println(s);
    }

    /**
     * 测试用，都返回false
     *
     * @return
     */
    public boolean isDebug() {
        return false;
    }

}

/**
 * lambda 惰性求值示例代码
 */
public class LazyDemo {

    public static void main(String[] args) {
        People user = new People();
        user.setName("晓风轻");

        MyLog log = new MyLog();

        System.out.println("--------1--------");
        // 第一种写法：字符串拼接白白执行了
        log.debug("打印一些字符串：" + user.toString());

        System.out.println("--------2--------");
        // 第2种写法：加判断
        // 代码不好看，而且isDebu方法执行了2次，浪费了一次
        if (log.isDebug()) {
            log.debug("打印一些字符串：" + user.toString());
        }

        System.out.println("--------3--------");
        // 第3种写法，利用lambda表达式实现惰性求值，完美
        log.debug(() -> "打印一些字符串：" + user.toString());

        System.err.println("----end----");
    }
}
