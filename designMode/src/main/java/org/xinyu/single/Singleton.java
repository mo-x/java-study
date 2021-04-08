package org.xinyu.single;

/**
 * Created by zzqno on 2017-2-26.
 */
public class Singleton {

    private Singleton(){}


    private static byte[] lock = new byte[0];
    private volatile static Singleton singleton;


    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (lock){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }

        }
        return singleton;
    }


}
