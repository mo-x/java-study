package org.goskyer.base.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Test {

    public static void main(String[] args) {
        Object object = new Object();
//        PhantomReference<Object> phantomReference = new PhantomReference<Object>();
        WeakReference<Object> weakReference = new WeakReference<>(object);
        SoftReference<Object> sf = new SoftReference<>(object);

    }
}