package com.duanyu.diy;

/**
 * @Description 环形队列
 * @Author Duanyu
 * @Date 2021-07-29 15:57
 * @Email z-houjie@qq.com / zkanan21@gmail.com
 */
public class CircleQueue implements Queue {

    /**
     * <p>1.front：指向队列的第一个元素，相当于初始 queue[front] 就表示队列的第一个元素</>
     * <p>2.rear：指向队列的最后一个元素的后一个位置,因为希望空出一个空间做为约定</>
     */

    /**
     * 默认最大容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 默认头部指针位置,初始指向头部
     */
    private static final int DEFAULT_HEAD = 0;

    /**
     * 默认尾部指针位置,指向最后一个元素的后一位
     */
    private static final int DEFAULT_TAIL = 0;

    private int maxSize; //数组最大容量

    private int front; //数组头部指针

    private int rear; //数组尾部指针

    private int[] queue;//模拟队列的数组


    public CircleQueue(){
        this(DEFAULT_CAPACITY);
    }

    public CircleQueue(int maxSize){
        this.maxSize = maxSize;
        this.front = DEFAULT_HEAD;
        this.rear  = DEFAULT_TAIL;
        this.queue = new int[this.maxSize];
    }

    /**
     * 由于 rear 的特性 需要 (rear + 1) == maxSize 为满
     * @return
     */
    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * rear - front 为有效个数
     * @return
     */
    @Override
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 添加数据
     * 由于rear就表示最后元素的后一位，所以直接当要加入位置的下标使用
     * 而考虑循环队列的特性（前面为空），应该取模 maxSize
     * @param n
     */
    @Override
    public void add(int n) {
        if (!isFull()){
            queue[rear] = n;
            rear = (rear + 1) % maxSize;
        }
        else System.out.println("队列已满,无法加入数据");
    }

    /**
     * 获取队列元素
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        return queue[index];
    }

    /**
     * 出队
     * @return
     */
    @Override
    public int out() {
        if (!isEmpty()){
            int v = queue[front];
            front = (front + 1) % maxSize;
            return v;
        }
        else throw new RuntimeException("队列为空");
    }

    /**
     * 展示队列
     */
    @Override
    public void showQueue() {
        if (!isEmpty()){
            StringBuilder builder = new StringBuilder();
            for (int i = front; i < front + size(); i++) {
                builder.append(queue[i % maxSize]+"\t");
            }
            System.out.println(builder.substring(0,builder.length()-1));
        }
        else System.out.println("队列为空");
    }
}
