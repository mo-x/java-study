package org.goskyer.jvm.lock;

import java.util.List;
import java.util.Vector;

/** -XX:+UseBiasedLocking --启用偏向锁 -XX:BiasedLockingStartupDelay=0 --偏向锁延迟时间 */
public class BiasLock {

  public static List<Integer> numberList = new Vector<Integer>();

  public static void main(String[] args) throws InterruptedException {
    long begin = System.currentTimeMillis();
    int count = 0;
    int startnum = 0;
    while (count < 10000000) {
      numberList.add(startnum);
      startnum += 2;
      count++;
    }
    long end = System.currentTimeMillis();
    System.out.println(end - begin);
  }
}
