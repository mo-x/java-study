package org.goskyer.base.question.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zzq on 16-10-25.
 */
public class MyComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge() < o2.getAge()){
            return  -1;
        }else if (o1.getAge() == o2.getAge()){
            return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("hello",88));
        list.add(new Person("hello",110));
        list.add(new Person("hello",1));
        list.add(new Person("hello",-2));
        Collections.sort(list, new MyComparator());
        for (Person p : list) {
            System.out.println("name:"+p.getName() +" age:"+p.getAge());
        }
    }


}
