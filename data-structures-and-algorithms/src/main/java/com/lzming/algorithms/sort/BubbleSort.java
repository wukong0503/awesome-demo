package com.lzming.algorithms.sort;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 * @Author lzming
 * @Date 1/8/20 19:51
 **/
public class BubbleSort {

    public static int[] solution(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4,2,3,1,5,9,8})));
    }
}
