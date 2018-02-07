package org.goskyer.list.map;

/**
 * 自定义hashMap实现
 *
 * @author
 */
public class CustomHashMap<K, V> {


    transient Element[] table;

    /**
     * 默认初始容量
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    // 默认加载因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * HashMap的阈值，用于判断是否需要调整HashMap的容量（threshold = 容量*加载因子）
     */
    int threshold;

    /**
     * 加载因子实际大小
     */
    final float loadFactor;

    transient int size;


    /**
     * 指定“容量大小”和“加载因子”的构造函数
     *
     * @param initialCapacity
     * @param loadFactor
     */
    public CustomHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {

            throw new IllegalArgumentException("Illegal initial capacity: " +
                                                       initialCapacity);
        }
        // HashMap的最大容量只能是MAXIMUM_CAPACITY
        if (initialCapacity > MAXIMUM_CAPACITY) {

            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {

            throw new IllegalArgumentException("Illegal load factor: " +
                                                       loadFactor);
        }
        // 找出“大于initialCapacity”的最小的2的幂
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;

        }
        // 设置“加载因子”
        this.loadFactor = loadFactor;
        // 设置“HashMap阈值”，当HashMap中存储数据的数量达到threshold时，就需要将HashMap的容量加倍。
        threshold = (int) (capacity * loadFactor);
        // 创建Entry数组，用来保存数据
        table = new Element[capacity];
        //init();
    }

    /**
     * 获取key对应的value
     */
    public V get(Object key) {
        if (key == null) {
            return getForNullKey();
        }
        // 获取key的hash值
        int hash = hash(key.hashCode());
        // 在“该hash值对应的链表”上查找“键值等于key”的元素
        for (Element<K, V> e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {

                return e.value;
            }
        }
        return null;
    }

    /**
     * 获取“key为null”的元素的值
     * HashMap将“key为null”的元素存储在table[0]位置！
     *
     * @return
     */
    private V getForNullKey() {
        for (Element<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                return e.value;
            }
        }
        return null;
    }

    /**
     * hash算法
     *
     * @param h
     * @return
     */
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public boolean isEmpty() {
        return table == null && size == 0;
    }


    /**
     * 返回索引值
     * h & (length-1)保证返回值的小于length
     *
     * @param h
     * @param length
     * @return
     */
    static int indexFor(int h, int length) {
        return h & (length - 1);
    }


    /**
     * 新增Entry。将“key-value”插入指定位置，bucketIndex是位置索引。
     */
    void addEntry(int hash, K key, V value, int bucketIndex) {
        // 保存“bucketIndex”位置的值到“e”中
        Element<K, V> e = table[bucketIndex];
        // 设置“bucketIndex”位置的元素为“新Entry”，
        // 设置“e”为“新Entry的下一个节点”
        table[bucketIndex] = new Element<K, V>(hash, key, value, e);
        // 若HashMap的实际大小 不小于 “阈值”，则调整HashMap的大小
        if (size++ >= threshold) {
            resize(2 * table.length);
        }
    }

    void resize(int newCapacity) {
        Element[] oldTable    = table;
        int       oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        // 新建一个HashMap，将“旧HashMap”的全部元素添加到“新HashMap”中，
        // 然后，将“新HashMap”赋值给“旧HashMap”。
        Element[] newTable = new Element[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    /**
     * 将HashMap中的全部元素都添加到newTable中
     *
     * @param newTable
     */
    void transfer(Element[] newTable) {
        Element[] src         = table;
        int       newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Element<K, V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Element<K, V> next = e.next;
                    int           i    = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }


    static class Element<K, V> {

        K             pre;
        /**
         * 下一个节点
         */
        Element<K, V> next;
        final   K key;
        private V value;

        final int hash;


        Element(int h, K k, V v, Element<K, V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }


        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        /**
         * 判断两个Entry是否相等
         * 若两个Entry的“key”和“value”都相等，则返回true。
         * 否则，返回false
         *
         * @param o
         * @return
         */
        @Override
        public final boolean equals(Object o) {
            if (!(o instanceof CustomHashMap.Element)) {
                return false;
            }
            CustomHashMap.Element e  = (CustomHashMap.Element) o;
            Object                k1 = getKey();
            Object                k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2))) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 实现hashCode()
         *
         * @return
         */
        @Override
        public final int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }

    }


}
