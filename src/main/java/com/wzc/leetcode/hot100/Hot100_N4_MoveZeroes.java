package com.wzc.leetcode.hot100;

import java.util.Arrays;

public class Hot100_N4_MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                continue;
            }
            if (zeroNum > 0) {
                nums[i - zeroNum] = nums[i];
                nums[i] = 0;
            }
        }
    }

}
