package org.goskyer.base.question.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zzq on 16-10-25.
 * 比较此对象与指定对象的顺序。如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    @Override
    public int compareTo(Person person) {
        int i = 0;
        i = name.compareTo(person.name); // 使用字符串的比较
        if (i == 0) { // 如果名字一样,比较年龄, 返回比较年龄结果
            return age - person.age;
        } else {
            return i; // 名字不一样, 返回比较名字的结果.
        }
    }

    public static void main(String[] args) {
        Person person = new Person("张三", 20);
        Person person1 = new Person("张三", 17);
        Person person2 = new Person("张三", 18);
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        list.add(person2);
        Person[] persons = new Person[3];
        persons[0] = person;
        persons[1] = person1;
        persons[2] = person2;
        Arrays.sort(persons);
        for (Person e : persons){
            System.out.println("name:"+ e.getName() + " age:"+e.getAge());
        }

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
