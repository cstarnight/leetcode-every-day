package com.wzc.leetcode.hot100;

public class Hot100_N7_TrappingRainWater {

    public static void main(String[] args) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    }

    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lMax = 0;
        int rMax = 0;

        int sum = 0;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (height[l] < height[r]) {
                sum += lMax - height[l];
                l++;
            } else {
                sum += rMax  - height[r];
                r--;
            }
        }
        return sum;
    }
}
