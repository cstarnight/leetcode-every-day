package com.wzc.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot100_N6_ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int tartget = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] < tartget) {
                    l++;
                } else if (nums[l] + nums[r] > tartget) {
                    r--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 继续相向移动左右指针，直到l=r-1,这个过程中还要去重
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
