package org.goskyer.base.copy;

import java.io.*;

/**
 * Created by zzqno on 2017-3-6.
 * 利用序列化来拷贝对象
 */
public class CloneUtils {

    public static <T extends Serializable> T clone(T obj) {

        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();
            out.close();
            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
        return cloneObj;
    }

}
