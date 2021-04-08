package org.xinyu.use.socket;

/**
 * Created by zzqno on 2017-4-9.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
