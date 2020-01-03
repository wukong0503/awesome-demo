package com.lzming.demo.juc;

import java.util.Stack;

/**
 * @Description 栈模拟队列
 * @Author lzming
 * @Date 1/3/20 16:32
 **/
public class FIFOWithStack<T> {
    private Stack<T> t1 = new Stack<>();
    private Stack<T> t2 = new Stack<>();

    public void push(T data) {
        t1.push(data);
    }

    public T pop() {
        if (t1.isEmpty() && t2.isEmpty()) {
            return null;
        }
        if (t2.isEmpty()) {
            // t2 为空的时候才放入新数据
            while (!t1.isEmpty()) {
                t2.push(t1.pop());
            }
        }
        return t2.pop();
    }

    public static void main(String[] args) {
        FIFOWithStack<String> fifo = new FIFOWithStack();
        fifo.push("1");
        fifo.push("2");
        fifo.push("3");

        System.out.println(fifo.pop());
        fifo.push("4");
        System.out.println(fifo.pop());
        System.out.println(fifo.pop());
        System.out.println(fifo.pop());
        System.out.println(fifo.pop());
    }

}
