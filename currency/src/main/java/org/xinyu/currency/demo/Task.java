package org.xinyu.currency.demo;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by monster_zzq on 2016/8/5.
 */
public class Task extends RecursiveAction {

    private static final long serialVersionUID = 1L;

    private List<Product> products;
    //声明两个私有的、int类型的属性first和last。这些属性将决定这个任务产品的阻塞过程。
    private int first;
    private int last;
    //声明一个私有的、double类型的属性increment，用来存储产品价格的增长。
    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        //如果last和first的差小于10（任务只能更新价格小于10的产品），使用updatePrices()方法递增的设置产品的价格。
        if (last-first < 10 ) {
            updatePrices();
        }else {
            //如果last和first的差大于或等于10，则创建两个新的Task对象，
            // 一个处理产品的前半部分，另一个处理产品的后半部分，然后在ForkJoinPool中，使用invokeAll()方法执行它们。
            int middle = ( last + first ) / 2;
            System.out.printf("Task: Pending tasks: %s\n",getQueuedTaskCount());
            Task t1 = new Task(products, first,middle+1, increment);
            Task t2 = new Task(products, middle+1,last, increment);
            invokeAll(t1,t2);
        }
    }
    //实现updatePrices()方法。这个方法更新产品队列中位于first值和last值之间的产品。
    private void updatePrices() {
        for (int i=first; i<last; i++){
            Product product = products.get(i);
            product.setPrice ( product.getPrice() * (1+increment) );
        }
    }


    public static void main(String[] args) {
        //使用ProductListGenerator类创建一个包括10000个产品的数列。
        ProductListGenerator generator=new ProductListGenerator();
        List<Product> products=generator.generate(10000);
        //创建一个新的Task对象，用来更新产品队列中的产品。first参数使用值0，last参数使用值10000（产品数列的大小）。
        Task task = new Task ( products , 0 , products.size() , 0.20);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        //实现一个显示关于每隔5毫秒池中的变化信息的代码块。将池中的一些参数值写入到控制台，直到任务完成它的执行。
        do {
            System.out.printf("Main: Thread Count: %d\n",pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n",pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n",pool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());
        pool.shutdown();
        //使用isCompletedNormally()方法检查假设任务完成时没有出错，在这种情况下，写入一条信息到控制台。
        if (task.isCompletedNormally()){
            System.out.printf("Main: The process has completed normally.\n");
        }
        //在增长之后，所有产品的价格应该是12。将价格不是12的所有产品的名称和价格写入到控制台，用来检查它们错误地增长它们的价格。
        for (int i=0; i<products.size(); i++){
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n",product.getName(),product.getPrice());
            }
        }
        System.out.println("Main: End of the program.\n");
    }



}
