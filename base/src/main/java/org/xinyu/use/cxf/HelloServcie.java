package org.xinyu.use.cxf;

import javax.jws.WebService;

/**
 * Created by zzqno on 2017-4-8.
 */
@WebService
public interface HelloServcie {

    String say(String name);
}
