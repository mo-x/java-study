package org.goskyer.list.linkedlist;


/**
 * Created by zzqno on 2017-4-16.
 * 静态链表 Java实现
 */
public class StaticLinkedList<T> {
    /**
     * 保存数据的数组
     */
    private Element<T>[] element;
    /**
     * 数组大小
     */
    public  int          size    = 0;
    /**
     * 记录下一个可用的位置下标
     */
    private int current;

    private int maxsize;

    /**
     * 构造器
     * 初始化Element[]
     *
     * @param size 自定义数组容量
     */
    public StaticLinkedList(int size) {
        element = new Element[size];
        for (int i = 0; i < size; i++) {
            element[i] = new Element<>(null, -1);
        }
        maxsize = size;
        current = 0;
        System.out.println("init StaticLinkedList...");
    }

    /**
     * 顺序插入
     *
     * @param item
     */
    public void add(T item) {
        //判断Element数组的容量是否允许添加元素 不够扩容
        if (current >= element.length) {
            expand();
        }
        //添加元素 cur
        Element<T> node = new Element<>(item, current + 1);
        element[current] = node;
        //修改相应属性
        current++;
        size++;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index > element.length) {
            return;
        }
        //首位元素
        if (index == 0) {
            element[0].data = null;
            element[0].cur = -1;
        } else {
            //上一位元素的指针指向待删除元素的后一位
            element[index - 1].cur = index + 1;
            //待删除元素修改
            element[index].cur = -1;
            element[index].data = null;
        }
        size--;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 下标
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > element.length) {
            return null;
        }
        return element[index].data;
    }

    /**
     * 扩容 原先的2倍
     */
    private void expand() {
        Element<T>[] oldElements = element;
        Element<T>[] newElements = new Element[element.length * 2];
        for (int i = 0; i < oldElements.length; i++) {
            newElements[i] = oldElements[i];
        }
        this.element = newElements;
        maxsize = element.length * 2;
    }

    /**
     * 打印输出Element<T>数组中添加的元素
     */
    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < element.length; i++) {
            if (element[i] != null) {
                if (element[i].cur != -1 && element[i].data != null) {
                    //通过判断当前元素的下一位指针数是否为null
                    if (element[i + 1] == null || element[i + 1].cur == -1) {
                        stringBuilder.append(element[i].data);
                    } else {
                        stringBuilder.append(element[i].data + ",");
                    }
                }
            }
        }
        stringBuilder.append("}");
        System.out.println(stringBuilder.toString());
    }

}


class Element<T> {
    /**
     * 记录存入的数据
     */
    T   data;
    /**
     * 记录下一个数据的下标
     */
    int cur;


    public Element(T data, int cur) {
        this.data = data;
        this.cur = cur;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }
}
