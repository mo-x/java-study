package org.xinyu.jvm;

/**
 * 栈上分配与逃逸分析是在JVM层面进行java性能优化的一个技巧 逃逸分析优化-栈上分配 *
 * 栈上分配,意思是方法内局部变量（未发生逃逸）生成的实例在栈上分配，不用在堆中分配，分配完成后，继续在调用栈内执行，最后线程结束，栈空间被回收，局部变量对象也被回收。 *
 * 一般生成的实例都是放在堆中的,然后把实例的指针或引用压入栈中。 *
 * 虚拟机参数设置如下，表示做了逃逸分析 消耗时间在10毫秒以下
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC
 * 虚拟机参数设置如下，表示没有做逃逸分析   消耗时间在1000毫秒以上
 * -server -Xmx10m -Xms10m -XX:-DoEscapeAnalysis -XX:+PrintGC
 */
public class OnStackTest {

    public static void alloc(){
        byte[] b=new byte[2];
        b[0]=1;
    }
    public static void main(String[] args) {
        long b=System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            alloc();
        }
        long e=System.currentTimeMillis();
        System.out.println(e-b);
    }
}
