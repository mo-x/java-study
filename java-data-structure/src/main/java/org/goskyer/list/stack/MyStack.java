package org.goskyer.list.stack;

import java.util.Arrays;

/**
 * 栈 先进后出
 */
public class MyStack {

    private Object[] elements;

    public int elementCount = 0;

    public MyStack() {

    }

    public MyStack(int size) {
        elements = new Object[size];
    }

    /**
     * todo 顺序问题
     * @param object
     */
    public void add(Object object) {
        if (this == null) {
            throw new NullPointerException(" curr stack is null");
        }
        if (elements == null) {
            elements = new Object[10];
        }
        //是否扩容
        if (elements.length == elementCount) {
            Object[] newArr = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArr, 0, elements.length);
            elements = newArr;
        }
        if (elementCount == 0) {
            elements[elements.length-1] = object;
        } else {
            elements[elements.length-1-elementCount] = object;
        }
        elementCount++;
    }

    public int size() {
        return elementCount;
    }


    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    public static void main(String[] args) {
    /*    int[] fun = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = new int[20];
        System.arraycopy(fun, 0, result, 0, fun.length);
        Arrays.stream(result).forEach(s -> {
            System.out.print(s);
        });*/
        MyStack myStack = new MyStack(5);
        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        myStack.add(4);
        myStack.add(5);
        myStack.add(6);
        myStack.add(7);


        System.out.println(myStack.toString());
        System.out.println(myStack.size());

    }


}

