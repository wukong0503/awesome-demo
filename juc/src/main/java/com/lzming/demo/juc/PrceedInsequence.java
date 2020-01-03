package com.lzming.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 启动3个线程打印递增的数字,
 *              线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15
 *              接着再由线程1打印16,17,18,19,20…
 *              以此类推, 直到打印到75.
 * @Date 1/3/20 12:39
 **/
public class PrceedInsequence {
    private int no = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition cond1 = lock.newCondition();
    private final Condition cond2 = lock.newCondition();
    private final Condition cond3 = lock.newCondition();

    private int curNum = 1;

    private void printNum() {
        if (curNum > 75) {
            Thread.currentThread().interrupt();
            return;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + curNum++);
        }
    }

    public void process1() {
        lock.lock();
        try {
            if (no != 1) {
                cond1.await();
            }
            printNum();
            no = 2;
            cond2.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void process2() {
        lock.lock();
        try {
            if (no != 2) {
                cond2.await();
            }
            printNum();
            no = 3;
            cond3.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void process3() {
        lock.lock();
        try {
            if (no != 3) {
                cond3.await();
            }
            printNum();
            no = 1;
            cond1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final PrceedInsequence p = new PrceedInsequence();
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                p.process1();
            }
        }).start();
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                p.process2();
            }
        }).start();
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                p.process3();
            }
        }).start();
    }

}
