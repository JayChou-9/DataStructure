package com.duanyu.diy;

/**
 * @Description 队列
 * @Author Duanyu
 * @Date 2021-07-29 16:04
 * @Email z-houjie@qq.com / zkanan21@gmail.com
 */
public interface Queue {

    /**
     * 是否以满
     * @return
     */
    boolean isFull();

    /**
     *是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取队列元素个数
     * @return
     */
    int size();

    /**
     * 添加数据
     * @param n
     */
    void add(int n);

    /**
     * 查看队列数据
     * @param index
     * @return
     */
    int get(int index);

    /**
     * 取出队列一个数据,出队列
     * @return
     */
    int out();


    /**
     * 显示队列数据
     */
    void showQueue();
}
