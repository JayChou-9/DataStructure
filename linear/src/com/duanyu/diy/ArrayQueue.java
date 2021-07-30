package com.duanyu.diy;

import com.duanyu.diy.Queue;

/**
 * @Description 模拟队列（先进先出）
 *  存在缺陷：数组只能使用一次（即使全部出队，还是显示队列已满）
 * @Author 段誉 Start
 * @Date 2021-07-28 17:23
 * @Email z-houjie@qq.com / zkanan21@gmail.com
 */
public class ArrayQueue implements Queue {

    /**
     * 默认最大容量
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 默认头部指针位置,初始指向头部前一个位置
     */
    private static final int DEFAULT_HEAD = -1;

    /**
     * 默认尾部指针位置,指向最后一个元素
     */
    private static final int DEFAULT_TAIL = -1;


    private int maxSize; //数组最大容量

    private int front; //数组头部指针

    private int rear; //数组尾部指针

    private int[] queue;//模拟队列的数组

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.front = DEFAULT_HEAD;
        this.rear = DEFAULT_TAIL;
        queue = new int[this.maxSize];
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return rear == (maxSize - 1);
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 获取队列长度
     * @return
     */
    public int size(){
        return rear - front;
    }

    /**
     * 添加数据
     * @param n
     */
    public void add(int n){
        if (!isFull()){
            queue[++ rear] = n;
        }
        else System.out.println("队列已满,无法加入数据");
    }

    /**
     * 查看队列数据
     * @param index
     * @return
     */
    public int get(int index){
        if (index < size()){
            index += front + 1;
            return queue[index];
        }
        else throw new ArrayIndexOutOfBoundsException("角标越界");
    }

    /**
     * 取出队列一个数据,出队列
     * @return
     */
    public int out(){
        if (!isEmpty()){
            return queue[++ front];
        }
        throw new RuntimeException("队列为空");
    }


    /**
     * 显示队列数据
     */
    public void showQueue(){
        if (!isEmpty()){
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < size(); i++) {
                int index = i + front + 1;
                builder.append(queue[i]+"\t");
            }
            System.out.println(builder.substring(0,builder.length()-1));
        }
        else System.out.println("当前队列为空");
    }
}
