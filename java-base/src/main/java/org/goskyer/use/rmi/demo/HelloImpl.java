package org.goskyer.use.rmi.demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by zzqno on 2016-9-23.
 */

/**
 * UnicastRemoteObject类的构造函数抛出了RemoteException，故其继承类不能使用默认构造函数，继承类的构造函数必须也抛出RemoteException
 * 由于方法参数与返回值最终都将在网络上传输，故必须是可序列化的
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {

    public HelloImpl() throws RemoteException {
    }

    public String sayHello(String name) throws RemoteException {
        return "sayHello" + name;
    }
}
