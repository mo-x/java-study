package org.xinyu.base.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by monster_zzq on 2016/7/18.
 */
public class Test {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",1);
        map.put("username","zzq");
        map.put("age",25);
        try {
            Test.test(map,User.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    public static <T> T test( Map < String , Object > map , Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        System.out.println ( t != null );
        Method[] methods = tClass.getMethods();
        for ( Method method : methods ) {
            if(method.getName().startsWith("set")){
                for ( String field : map.keySet() ) {
                    
                }
            }
        }
        return t ;
    }
}
