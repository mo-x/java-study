package org.goskyer.list.linkedlist;

/**
 * 环形列表实现
 *
 * @param <E>
 */
public class AnnularLinkedList<E> {

    private ElmentObj[] elements;

    private int defaultSize = 10;
    private int       size;
    private ElmentObj header;
    private ElmentObj curr;


    public AnnularLinkedList() {
        this.elements = new ElmentObj[defaultSize];
        this.size = defaultSize;
    }

    public AnnularLinkedList(int size) {
        this.elements = new ElmentObj[size];
        this.size = size;
    }

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

        }
        size++;
    }

    public void remove(int index) {
        if (index < 0) {
            return;
        }
        if (header == null) {
            return;
        }
        ElmentObj obj   = header;
        int       start = 0;

    }

    





    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (header != null) {
            ElmentObj obj = header;
            while (obj.next != null) {
                stringBuilder.append(obj.data);
                if (obj.next == header) {
                    break;
                }
            }
        }
        stringBuilder.append("}");
    }


    public static void main(String[] args) {
        AnnularLinkedList<Integer> annularLinkedList = new AnnularLinkedList<>();
        annularLinkedList.add(1);
        annularLinkedList.print();
        annularLinkedList.remove(0);

    }

    class ElmentObj<E> {

        private E         data;
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
