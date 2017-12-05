package org.goskyer.thread.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zzqno on 2017-3-10.
 */
public class CreateThreadByCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i <10 ; i++) {
            System.out.println("thread calll"+i);
        }
        return "call";
    }

    public static void main(String[] args) {

        CreateThreadByCallable createThreadByCallable = new CreateThreadByCallable();
        FutureTask<String> futureTask = new FutureTask<String>(createThreadByCallable);
        new Thread(futureTask).start();
        try {
            //调用get方法 主线程阻塞执行。否则异步。
            //get()得到call()方法返回的结果
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
