package org.xinyu.base.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        List<String> collect = Stream.of("1111", "2222", "333").collect(Collectors.toList());

        List<String> list = collect;
        collect.add("44444");
        System.out.println(list.toString());


        List<String> list1 = Stream.of("aaaa", "bbb", "ccc").collect(Collectors.toList());
        List<String> strings = new ArrayList<>(list1);
        collect = list1;
        collect.add("55555");
        String[]     strings1 = Arrays.copyOf(list1.toArray(), list1.size(), String[].class);
        List<String> objects  = Arrays.asList(strings1);
        System.out.println(objects == list1);
        new ArrayList();
        System.out.println(strings == list1);

        System.out.println(list1.toString());
        System.out.println(strings.toString());

    }
}
