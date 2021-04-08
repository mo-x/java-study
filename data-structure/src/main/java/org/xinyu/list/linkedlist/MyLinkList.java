package org.xinyu.list.linkedlist;

import java.util.HashSet;

/**
 * Created by monster_zzq on 2016/8/7.
 * 单向链表表Java实现
 * @author zhiqing.zhang
 */
public class MyLinkList {

    /**
     * 头节点
     * 用于保存首个节点信息
     */
    private Node head;

    /**
     * 当前节点 用于保存
     */
    private Node currNode = null;

    /**
     * 构造器 用于初始化链表的头部信息
     */
    public MyLinkList() {
        head = null;
    }

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 添加
     * 采用的是头插法
     *
     * @param data
     */
    public void insert(int data) {
        //构造当前的
        Node node = new Node();
        node.next = head;
        head = node;
    }


    /**
     * 指定位置插入
     *
     * @param index
     * @param data
     */
    public void insert(int index, int data) {
        if (index > size || index < 0) {
            return;
        }
        //若插入的位置是头节点
        if (index == 0) {
            Node node = new Node();
            node.data = data;
            Node temp = head;
            head = node;
            node.next = temp;
            currNode = node;
            return;
        }
        int count = 0;
        Node temp = head;
        while (temp.next != null) {
            count++;
            if (count == index) {
                temp.next.data = data;
            }
            temp = temp.next;
            size++;
        }
    }

    /**
     * 尾插法
     *
     * @param data
     */
    public void insertEnd(int data) {
        if (head == null) {
            Node node = new Node(data);
            head = node;
            currNode = node;
            size++;
            return;
        }
        Node node = new Node(data);
        currNode.next = node;
        currNode = node;
        size++;
    }

    /**
     * 获取某个位置的值
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (head == null) {
            return -1;
        }
        if (index == 0) {
            return head.data;
        }
        int count = 0;
        Node element = new Node();
        Node temp = head;
        while (temp.next != null) {
            count++;
            if (count == index) {
                element.data = temp.next.data;
            }
            temp = temp.next;
        }
        return element.data;
    }


    /**
     * 删除某个位置元素
     *
     * @param index
     */
    public void del(int index) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        int count = 0;
        Node element;
        Node temp = head;
        while (temp.next != null) {
            count++;
            if (count == index) {
                element = temp.next.next;
                temp.next = element;
            }
            temp = temp.next;
        }
    }

    /**
     * 清空链表
     * 将节点赋值null
     */
    public void clear() {
        for (Node x = head; x != null; ) {
            Node next = x.next;
            x.next = null;
            x.data = 0;
            x = next;
        }
        head = null;
        size = 0;
    }

    /**
     * 打印链表的数据内容
     * 注意此处 先打印头节点
     */
    protected void print() {
        StringBuilder stringBuilder = new StringBuilder();
        if (head == null) {
            System.out.println("this linkedlist is empty");
            return;
        }
        stringBuilder.append(head.data + ",");
        Node temp = head;
        while (temp.next != null) {
            //尾节点的指针域肯定为null 先在此处赋值 可以遍历到该节点
            //不先赋值会重复输出头节点的元素
            temp = temp.next;
            if (temp.next == null) {
                stringBuilder.append(temp.data);
            } else {
                stringBuilder.append(temp.data + ",");
            }
        }
        System.out.println(stringBuilder.toString());
    }


    public static void main(String[] args) {
        HashSet s = new HashSet<>();
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.insertEnd(3);
        myLinkList.insertEnd(4);
        myLinkList.insert(0, 5);
        System.out.println(myLinkList.get(1));
        myLinkList.print();
        myLinkList.del(0);
        myLinkList.print();
        myLinkList.clear();
        myLinkList.print();
    }
}