package org.goskyer.base.proxy;

/**
 * Created by zzqno on 2017-3-27.
 */
public class HelloImpl implements Hello {
    public void say(String name) {
        System.out.println("Hello" + name);
    }
}
