package com.wzc.leetcode.hot100;

public class Hot100_N5_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = Math.min(height[l], height[r]) * (r - l);
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
        }
        return max;
    }
}
