package arraylist;

import java.util.Arrays;

/**
 * Created on 2020/5/10.
 * 自己实现一个简单的ArrayList
 *
 * @author etlRlks
 */
public class MyArrayList<E> {

    //主要方法: add(),  set(), get(), size(), remove()

    //初始化方式: 这里实现两种
    //无參, 指定大小初始化

    //数组的元素长度size
    private static int size = 0;

    //默认容量
    private static final int DEFAULT_CAPACITY = 10;

    //默认数组实现
    private Object[] data;

    //默认定义一个空数组
    private Object[] defaultData = {};

    //无參构造
    public MyArrayList() {
        this.data = defaultData;
    }

    //指定大小初始化
    public MyArrayList(int capacity) {
        this.data = new Object[capacity];
    }

    //add()
    public boolean add(E e) {
        //保证存储当前元素的最小容量
        ensureCapacity(size + 1);
        data[size] = e;
        size++;
        return true;
    }

    private void ensureCapacity(int minCap) {
        if (minCap > data.length) {
            minCap = Math.max(DEFAULT_CAPACITY, minCap);
        }
        incrementList(minCap);
    }

    private void incrementList(int minCap) {
        int oldCap = data.length;
        int newCap = oldCap + oldCap / 2;

        if (newCap < minCap) {
            newCap = minCap;
        }
        Object[] obj = new Object[newCap];
        System.arraycopy(data, 0, obj, 0, size);
        this.data = obj;
    }

    public E get(int index) {
        rangeCheckIndex(index);
        return (E)this.data[index];
    }

    //根据索引移除元素
    public E remove(int index) {
        rangeCheckIndex(index);

        E e = (E) this.data[index];

        //使用copyOf
        int size_index = index + 1;
        int movenum = size - index - 1;
        System.arraycopy(data, size_index, data, index, movenum);

        //将最后一个元素设null, 使GC执行操作
        this.data[--size] = null;

        return e;
    }

    //检查是否越界
    private void rangeCheckIndex(int index) {
        if (index == size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (index < 0) {
            throw new IllegalArgumentException("非法索引");
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size() {
        return this.size;
    }

}
