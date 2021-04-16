package org.xinyu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountString {

    public void count(String[] strings, String str) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {

        }

    }

    public static int count(String string, String str) {
        if (!string.contains(str)) {
            return 0;
        }
        int start = 0;
        int end = string.length();
        return 0;
    }

    public static int count1(String string, String str) {
        if (!string.contains(str)) {
            return 0;
        }
        String replace = string.replace(str, "");

        return (string.length() - replace.length()) / str.length();
    }

}
