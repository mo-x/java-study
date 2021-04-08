package org.xinyu.thread.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzqno on 2017-4-5.
 * ThreadLocal原理实现
 * container 为map结构来保存与当前线程绑定的变量 来达到变量的隔离效果
 * @author zhiqin.zhang
 */
public class MyThreadLocal<T> {


    private Map<Thread, T> container = Collections.synchronizedMap(new HashMap<Thread, T>());

    public void set(T value){
        container.put(Thread.currentThread(), value);
    }

    public T get(){
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if (value == null && !container.containsKey(thread)) {
            value = initialValue();
            container.put(thread,value);
        }
        return value;
    }

    public void remove(){
        container.remove(Thread.currentThread());
    }


    protected T initialValue(){
        return null;
    }
}
