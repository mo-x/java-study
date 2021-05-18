package org.xinyu.mapexample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

  public static void main(String[] args) {
    //
    int h = "hello".hashCode();
    int w = "world".hashCode();
    int hash = (h ^ (h >>> 16)) & 0x7fffffff;
    int hashw = (w ^ (w >>> 16)) & 0x7fffffff;
    System.out.println("hash =" + hash);
    System.out.println("15");
    System.out.println("15&hash=" + (15 & hash));
    System.out.println("31&hash=" + (31 & hash));

    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap();
    concurrentHashMap.put("hello", "world");

    Map<String, String> map = new HashMap<>();
    map.put("hello", "world");
    map.put("hello", "world");
    map.put("hello", "world");
  }
}
