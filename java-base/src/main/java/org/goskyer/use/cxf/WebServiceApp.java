package org.goskyer.use.cxf;

import javax.xml.ws.Endpoint;

/**
 * Created by zzqno on 2017-4-8.
 * WebService 服务端接口注册
 */
public class WebServiceApp {
    public static void main(String[] args) {
        System.out.println("web service start");
        HelloServiceImpl implementor= new HelloServiceImpl();
        String address="http://localhost:8080/helloWorld";
        Endpoint.publish(address, implementor);
        System.out.println("web service started");
    }
}
