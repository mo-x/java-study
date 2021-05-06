package org.xinyu.single;

import java.util.Vector;

/**
 * Created by zzqno on 2017-3-14.
 */
public class SingletonByStatic {

    private  static volatile SingletonByStatic singleton;


    private SingletonByStatic() {

    }

    public SingletonByStatic getInstance() throws Exception {
        if (singleton == null) {
            synchronized (SingletonByStatic.class) {
                if (singleton == null) {
                    System.out.println("getInstance");
                    singleton = new SingletonByStatic();
                }
            }

        }
        return singleton;
    }

    public static void main(String[] args) throws Exception {
        SingletonByStatic byStatic = new SingletonByStatic().getInstance();
        SingletonByStatic byStatic1 = new SingletonByStatic().getInstance();
        System.out.println(byStatic == byStatic1);
        Vector<SingletonByStatic> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        SingletonByStatic byStatic = new SingletonByStatic().getInstance();
                        vector.add(byStatic);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
        Thread.sleep(5000);
        System.out.println(vector.size());
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }
    }

}
