package org.xinyu.jvm;

import java.util.ArrayList;

/**
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * 运行时常量池
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用List保持着常量池引用 避免Full GC 回收常量池行为
        ArrayList<String> objects = new ArrayList<>();
        int i = 0;
        while (true){
            objects.add(String.valueOf(i++).intern());
        }
    }
}
