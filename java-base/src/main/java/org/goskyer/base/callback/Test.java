package org.goskyer.base.callback;

/**
 * Created by zzq on 16-10-20.
 */
public class Test {
    public static void main(String[] args) {
        new TestCallBack().compute(1000, new ComputeCallBack() {
            public void onComputeEnd() {
                System.out.println("end back!!!");
            }
        });
    }
}
