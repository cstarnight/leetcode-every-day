package com.wzc.leetcode.hot100;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Hot100_N3_LongestConsecutive {

    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int result = longestConsecutive(nums);
        System.out.println(result);
    }

    /**
     *
     * 用hash存数实现O(1)复杂度的查找，
     * 然后遍历过程中，判断当前数x是否存在x-1,存在直接跳过。
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        // 1.先去重
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        // 2.然后判断当前数x是否是序列开始的第一个数，判断条件是:是否存在x-1,如果不存在，则是第一个数，接下来开始找x+1,x+2……
        int max = 1;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int i = 1;
                while (set.contains(num + i)) {
                    i++;
                }
                if (max < i) {
                    max = i;
                }
            }
        }
        return max;
    }

    public static int longestConsecutive1(int[] nums) {
        Set<Integer> sets = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longStreak = 0;
        for (Integer num : sets) {
            if (!sets.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (sets.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longStreak = Math.max(longStreak, currentStreak);
            }
        }

        return longStreak;
    }

}

