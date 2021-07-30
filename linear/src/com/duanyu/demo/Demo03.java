package com.duanyu.demo;

import com.duanyu.diy.CircleQueue;

/**
 * @Description 环形队列案例
 * @Author Duanyu
 * @Date 2021-07-29 17:25
 * @Email z-houjie@qq.com / zkanan21@gmail.com
 */
public class Demo03 {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(5);
        circleQueue.add(1);
        circleQueue.add(2);
        circleQueue.add(3);
        circleQueue.add(4);
        circleQueue.add(5);

        circleQueue.showQueue();

        circleQueue.out();
        circleQueue.add(5);

        circleQueue.showQueue();
    }
}
