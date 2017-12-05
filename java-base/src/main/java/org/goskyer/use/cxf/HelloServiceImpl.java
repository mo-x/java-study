package org.goskyer.use.cxf;

import javax.jws.WebService;

/**
 * Created by zzqno on 2017-4-8.
 */

@WebService(endpointInterface = "service.HelloServcie",serviceName = "HelloWorld")
public class HelloServiceImpl implements HelloServcie{

    @Override
    public String say(String name) {
        return name;
    }
}
