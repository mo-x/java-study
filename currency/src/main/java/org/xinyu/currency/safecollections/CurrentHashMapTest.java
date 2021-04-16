package org.xinyu.currency.safecollections;

import java.util.concurrent.ConcurrentHashMap;

public class CurrentHashMapTest {


    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap();
        map.put("1", 1);
        map.put("2", 2);
        map.put("1", 2);
        System.out.println(1 << 30);

    }
}
