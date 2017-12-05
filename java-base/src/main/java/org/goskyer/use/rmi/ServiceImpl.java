package org.goskyer.use.rmi;

/**
 * Created by zzqno on 2016-9-23.
 */
public class ServiceImpl implements Service {

    public void service(String name) {
        System.out.println(name);
    }
}
