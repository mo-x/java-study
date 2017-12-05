package org.goskyer.use.rmi;

import java.io.Serializable;
import java.rmi.Remote;

/**
 * Created by zzqno on 2016-9-23.
 */
public interface Service extends Remote,Serializable {

    void service(String name);

}
