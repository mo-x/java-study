package org.xinyu.list.linkedlist;

/**
 * 环形列表实现
 *
 * @param <E>
 * @author zhiqin.zhang
 */
public class AnnularLinkedList<E> {
  // 默认数组长度
  private static int DEFAULT_SIZE = 10;
  private int size;
  private ElmentObj header;
  private ElmentObj curr;

  public AnnularLinkedList() {
    this.size = DEFAULT_SIZE;
  }

  public AnnularLinkedList(int size) {
    this.size = size;
  }

  /**
   * 添加节点
   *
   * @param data
   */
  public void add(E data) {
    ElmentObj elmentObj = new ElmentObj<>(data);
    if (header == null) {
      header = new ElmentObj<>(null);
      header.next = elmentObj;
      elmentObj.pre = header;
      elmentObj.next = header;
      curr = elmentObj;
    } else {
      curr.next = elmentObj;
      elmentObj.pre = curr;
      elmentObj.next = header;
      curr = elmentObj;
    }
    size++;
  }

  /**
   * 根据下标删除节点
   *
   * @param index
   */
  public void remove(int index) {
    if (!isElementIndex(index)) {
      // 下标越界
      return;
    }
    if (header == null) {
      // 空链表
      return;
    }
    int length = 0;
    ElmentObj elmentObj;
    ElmentObj temp = header;
    while (temp.next != null) {
      length++;
      if (length == index) {
        elmentObj = temp.next;
        temp.next.pre = elmentObj;
        temp.next = temp;
      }
    }
    /*for (ElmentObj temp = header; temp != null; temp = temp.next) {
        ++length;
        if (length == index) {
            ElmentObj next = temp.next;
            ElmentObj pre  = temp.pre;
            pre.next = pre;
            next.pre = pre;
            return;
        }
    }*/

  }

  /** 打印输出节点所有数据 */
  public void print() {
    StringBuilder stringBuilder = new StringBuilder();
    if (header == null) {
      System.out.println("this linkedList is empty");
      return;
    }
    ElmentObj temp = header;
    while (temp.next != header) {
      // 尾节点的指针域肯定为header 先在此处赋值 可以遍历到该节点
      // 不先赋值会重复输出头节点的元素
      temp = temp.next;
      if (temp.next == header) {
        if (temp.data != null) {
          stringBuilder.append(temp.data);
        }
      } else {
        stringBuilder.append(temp.data).append(",");
      }
    }
    System.out.println(stringBuilder.toString());
  }

  private boolean isElementIndex(int index) {
    return index >= 0 && index < size;
  }

  public static void main(String[] args) {
    AnnularLinkedList<Integer> annularLinkedList = new AnnularLinkedList<>();
    annularLinkedList.add(1);
    annularLinkedList.add(2);
    annularLinkedList.remove(1);
    annularLinkedList.print();
  }

  /**
   * 指针域
   *
   * @param <E>
   */
  class ElmentObj<E> {

    private E data;
    private ElmentObj next;
    private ElmentObj pre;

    public ElmentObj(E data) {
      this.data = data;
    }

    public ElmentObj getNext() {
      return next;
    }

    public void setNext(ElmentObj next) {
      this.next = next;
    }

    public ElmentObj getPre() {
      return pre;
    }

    public void setPre(ElmentObj pre) {
      this.pre = pre;
    }

    public E getData() {
      return data;
    }

    public void setData(E data) {
      this.data = data;
    }
  }
}
