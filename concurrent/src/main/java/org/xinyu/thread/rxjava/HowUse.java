package org.xinyu.thread.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.apache.log4j.Logger;

/**
 * @author zhangzhiqin
 * @create 2017-12-06 11:54
 **/
public class HowUse {

    static Logger log = Logger.getLogger(HowUse.class);

    public static void main(String[] args) {
        // 第一步：初始化Observable
        // 第三步：订阅
        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            //log.info();
            System.out.println("Observable emit 1" + "\n");
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
            e.onComplete();
            e.onNext(4);
        }).subscribe(new Observer<Integer>() {

            // 第二步：初始化Observer
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                i++;
                if (i == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    mDisposable.dispose();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                log.info("onError : value : " + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {
                log.info("onComplete" + "\n");
            }
        });



        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                System.out.println("Observable thread is : " + Thread.currentThread().getName());
                e.onNext(1);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
               // .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        System.out.println("After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.io())
                .subscribe(integer -> System.out.println("After observeOn(io)，Current thread is " + Thread.currentThread().getName()));




    }
}