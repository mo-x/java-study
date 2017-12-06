package org.goskyer.observer;

/**
 * 被观察者
 * @author zhangzhiqin
 * @create 2017-12-06 10:56
 **/
public interface Subject {


    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();

}