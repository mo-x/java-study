package org.goskyer.base.newfeature.close;

import java.util.Optional;

/**
 * Created by zhangzhiqin on 2017/6/14.
 * Optional 来防止空指针异常
 */
public class OptionalTest {

    public static void main(String[] args) {
        //调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("Sanaulla");
        //传入参数为null，抛出NullPointerException.
        //Optional<String> someNull = Optional.of(null);
        Optional empty = Optional.ofNullable(null);
        //System.out.println(empty);
        //isPresent方法用来检查Optional实例中是否包含值
        if (empty.isPresent()) {
            //在Optional实例内调用get()返回已存在的值
            System.out.println(name.get());//输出Sanaulla
        }
        //如果Optional实例有值，调用ifPresent()可以接受接口段或lambda表达式
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });
        System.out.println(empty.orElse("There is no value present!"));
        //输出：Sanaulla
        System.out.println(name.orElse("There is some value!"));

        //orElseGet与orElse方法类似，区别在于orElse传入的是默认值，
        //orElseGet可以接受一个lambda表达式生成默认值。
        //输出：Default Value
        System.out.println(empty.orElseGet(() -> "Default Value"));
        //输出：Sanaulla
        System.out.println(name.orElseGet(() -> "Default Value"));

        try {
            //orElseThrow与orElse方法类似。与返回默认值不同，
            //orElseThrow会抛出lambda表达式或方法生成的异常
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            //输出: No value present in the Optional instance
            System.out.println(ex.getMessage());
        }


    }
}

class ValueAbsentException extends Throwable {

    public ValueAbsentException() {
        super();
    }

    public ValueAbsentException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "No value present in the Optional instance";
    }
}