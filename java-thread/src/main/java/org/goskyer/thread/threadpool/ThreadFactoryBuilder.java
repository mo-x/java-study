package org.goskyer.thread.threadpool;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂
 *
 * @author zhiqing.zhang
 */
@Data
public class ThreadFactoryBuilder implements ThreadFactory {

  private AtomicInteger count;
  private String name;

  public ThreadFactoryBuilder(String name) {
    count = new AtomicInteger(0);
    this.name = name;
  }

  @Override
  public Thread newThread(@NotNull Runnable r) {
    Thread thread = new Thread();
    thread.setName(name);
    count.getAndAdd(1);
    return thread;
  }
}
