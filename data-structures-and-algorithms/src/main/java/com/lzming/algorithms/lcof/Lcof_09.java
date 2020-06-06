package com.lzming.algorithms.lcof;

import java.util.Stack;

public class Lcof_09 {

    public class CQueue {
        private Stack<Integer> firstStack;
        private Stack<Integer> secondStack;
        public CQueue() {
            firstStack = new Stack<>();
            secondStack = new Stack<>();
        }

        // 尾部插入
        public void appendTail(int value) {
            firstStack.push(value);
        }

        // 头部删除
        public int deleteHead() {
            if (!secondStack.empty()) {
                return secondStack.pop();
            }

            while (firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }
            if (!secondStack.empty()) {
                return secondStack.peek();
            }
            return -1;
        }
    }


}
