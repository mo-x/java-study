package org.goskyer.use.socket;

/**
 * Created by zzqno on 2017-4-9.
 * 启动服务类
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
