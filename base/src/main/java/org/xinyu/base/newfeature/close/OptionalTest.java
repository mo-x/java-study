package org.xinyu.base.newfeature.close;

import java.util.Optional;

/**
 * Created by zhangzhiqin on 2017/6/14.
 * Optional：
 * 来防止空指针异常
 * 减少if else判断逻辑 使代码更优雅
 *
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

        City city = new City();
        Optional<City> optionalCity = Optional.ofNullable(city);
        String s = optionalCity
                .map(City::getName).orElse("No1");
        City myCity = new City();
        myCity.setCityNo("");
        myCity.setAlias("乌托邦");
        //myCity.setName("乌托邦");
        String s1 = Optional.ofNullable(myCity.getCityNo()).orElse(myCity.getAlias());
        String s2 = Optional.ofNullable(myCity).map(City::getName).map(c -> c.isEmpty() ? myCity.getAlias() : c).get();


        System.out.println(s1);
        System.out.println("s2:" + s2);
        String default_city = Optional.ofNullable(myCity.getCityNo()).orElse(myCity.getAlias());
        System.out.println(default_city);

        Country country = new Country();
        country.setCity(myCity);
        String default_country = Optional.of(country)
                .map(Country::getCity)
                .map(City::getName)
                .orElse("default country");
        System.out.println(default_country);


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


class City {
    private String name;
    private String cityNo;
    private String alias;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}

class Country {

    private City city;
    private String name;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}