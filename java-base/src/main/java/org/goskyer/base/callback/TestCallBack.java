package org.goskyer.base.callback;

/**
 * Created by zzq on 16-10-20.
 */
public class TestCallBack {

    public void compute(int n, ComputeCallBack callback) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
        callback.onComputeEnd();
    }
}
