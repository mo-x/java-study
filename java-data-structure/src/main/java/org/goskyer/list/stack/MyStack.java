package org.goskyer.list.stack;

import java.util.Arrays;

/**
 * 栈 后进后出
 * 目前实现的结构只能使用一次。若需要反复利用该栈 需要在压栈的时候做处理
 * @author zhiqin.zhang
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
     * 压栈
     *
     * @param object
     */
    public void push(Object object) {
        if (elements == null) {
            elements = new Object[10];
        }
        if (elements.length == elementCount) {
            throw new RuntimeException("栈已经满了");
        }
        if (elementCount == 0) {
            elements[elements.length - 1] = object;
        } else {
            elements[elements.length - 1 - elementCount] = object;
        }
        elementCount++;
    }

    public Object pop() {
        if (elementCount == 0) {
            throw new RuntimeException("栈已经空了");
        }
        Object result = elements[0];
        Object[] newArr = new Object[elements.length - 1];
        System.arraycopy(elements, 1, newArr, 0, elements.length - 1);
        elements = newArr;
        elementCount = elementCount - 1;
        return result;
    }

    public int size() {
        return elementCount;
    }


    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.toString());
        System.out.println(myStack.size());

    }


}

