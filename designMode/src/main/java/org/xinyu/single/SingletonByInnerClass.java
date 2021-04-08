package org.xinyu.single;

/**
 * Created by zzqno on 2017-5-8.
 */
public class SingletonByInnerClass {

    private SingletonByInnerClass() {
        System.out.println("out");
    }

    private static class SingletonHolder {
        private static final SingletonByInnerClass INSTANCE = new SingletonByInnerClass();
      /*  static {
            System.out.println(INSTANCE == null);
        }*/

        public SingletonHolder() {
            System.out.println("inner");
        }
    }

    public static final SingletonByInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public static void main(String[] args) {
        SingletonByInnerClass s1 = SingletonByInnerClass.getInstance();
        SingletonByInnerClass s2 = SingletonByInnerClass.getInstance();
        System.out.println(s1 == s2);
    }
}
