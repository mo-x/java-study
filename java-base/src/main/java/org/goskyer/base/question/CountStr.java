package org.goskyer.base.question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by zzq on 16-10-23.
 * 查找字符串中出现最多次数的字符
 */
public class CountStr {


    /**
     * 获取字符串中出现次数最多的字符
     *
     * @param str
     * @return
     */
    public static Character getStr(String str) {
        if (str.isEmpty() || str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        char currChar;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            currChar = chars[i];
            if (countMap == null || countMap.isEmpty()) {
                countMap.put(currChar, 1);
            } else {
                if (countMap.containsKey(currChar)) {
                    countMap.put(currChar, countMap.get(currChar) + 1);
                } else {
                    countMap.put(currChar, 1);
                }
            }
        }
        return findMapMaxValue(countMap);
    }

    /**
     * 查找map中出现次数最多的值
     *
     * @param map
     * @return
     */
    public static Character findMapMaxValue(Map<Character, Integer> map) {
        Set<Character> keys = map.keySet();// 获得所有key值
        Iterator keys_Itera = keys.iterator();// 实例化Iterator

        Character maxKey = (Character) keys_Itera.next();
        int maxValue = map.get(maxKey);

        while (keys_Itera.hasNext()) {
            Character temp = (Character) keys_Itera.next();
            if (maxValue < map.get(temp)) {
                maxKey = temp;
                maxValue = map.get(temp);
            }
        }
        System.out.println("出现次数最多的字符：" + maxKey + " 出现次数：" + maxValue);
        return maxKey;
    }


    /**
     * 另一种方法
     * 通过遍历集合达到目的
     * @param str
     * @return
     */
    public static Character getCount(String str){
        char[] StrArr = str.toCharArray();// 把字符串转为字符数组toCharArray
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        if (!(StrArr == null || StrArr.length == 0))
            for (int i = 0; i < StrArr.length; i++)
                if (null != map.get(StrArr[i]))
                    map.put(StrArr[i], map.get(StrArr[i]) + 1);
                else
                    map.put(StrArr[i], 1);

        // 找map中Value的最大值maxValue，类似于选择排序，寻找最大值的过程：
        // 先任取一个Value值定义为最大值，然后与之比较
        int maxValue = map.get(StrArr[0]);
        char ch = ' ';
        for (int j = 0; j < StrArr.length; j++)
            if (maxValue < map.get(StrArr[j])) {
                maxValue = map.get(StrArr[j]);
                ch = StrArr[j];
            }
        System.out.println("现次数最多的字符：" + ch + " 出现次数：" + maxValue);
        return  ch;
    }



    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("h", "hello");
        System.out.println(map.containsKey('h'));
      //  System.out.println(CountStr.getStr("aaabbcddddee"));
        System.out.println(CountStr.getCount("aaabbcddddee"));
    }
}
