package com.lzming.algorithms.lcof;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 数组中重复的数字
 * @Author lzming
 * @Date 2020/5/27 10:32
 **/
public class Lcof_3 {
    private int findRepeatNumber(int[] nums) {
        Set<Integer> exist = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!exist.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}
