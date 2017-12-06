package org.goskyer.single;

/**
 * Created by zzqno on 2017-5-8.
 */
public class TestSingleton {

    private static volatile TestSingleton _instance = null;

    private TestSingleton() {}

    public static TestSingleton getInstance() {

        if (_instance == null) {
            _instance = new TestSingleton();
            System.out.println("--initialized once.");
        }

        return _instance;
    }

    public static void main(String[] args) {
 /*       Thread t1 = new Thread(new LoopInit());
        Thread t2 = new Thread(new LoopInit2());
        Thread t3 = new Thread(new LoopInit());
        Thread t4 = new Thread(new LoopInit2());
        t1.start();
        t2.start();
        t3.start();
        t4.start();*/
    }

}
