package com.duanyu.demo;

import com.duanyu.diy.ArrayQueue;

/**
 * @Description 队列（先进先出）
 * 场景：如银行排队叫号
 * @Author 段誉 Start
 * @Date 2021-07-28 15:44
 * @Email z-houjie@qq.com / zkanan21@gmail.com
 */
public class Demo02 {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        System.out.println(arrayQueue.size());
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);
        arrayQueue.showQueue();

        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.size());

        arrayQueue.showQueue();

        System.out.println(arrayQueue.get(1));

    }
}


