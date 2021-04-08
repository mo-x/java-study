package org.xinyu.use.rmi.demo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by zzqno on 2016-9-23.
 *
 */

/**
 * 1，创建远程方法接口，该接口必须继承自Remote接口
 Remote 接口是一个标识接口，用于标识所包含的方法可以从非本地虚拟机上调用的接口，Remote接口本身不包含任何方法
 */
public interface Hello extends Remote {
    String sayHello(String name) throws RemoteException;
}
