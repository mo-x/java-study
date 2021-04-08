package org.xinyu.base.newfeature.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by zzqno on 2017-6-25.
 *
 */
public class Test {

    public static void main(String[] args) {
        Test:numberCreate();
    }

    /**
     *  构造流的方式
     */
    public void createStream(String str){
        //1
        Stream stream = Stream.of("a", "b", "c");
        //2 Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        //3.Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }


    /**
     * 数值流的构造
     */
    public static void numberCreate(){
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::print);
        IntStream.range(1, 3).forEach(System.out::print);//1 2
        IntStream.rangeClosed(1, 3).forEach(System.out::print);//123
    }


}
