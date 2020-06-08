package com.lzming.algorithms.lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 斐波那契数列
 * @Author lzming
 * @Date 2020/6/8 16:51
 **/
public class Lcof_10_1 {

    static Map<Integer, Integer> data = new HashMap<>();

    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        initMap(n);
        return data.get(n);
    }

    private static void initMap(int n) {
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    data.put(i, 1);
                } else if (i == 2) {
                    data.put(i, 1);
                } else {
                    data.put(i, (data.get(i - 1) + data.get(i - 2)) % 1000000007);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(48));
        System.out.println(data);
    }
}
