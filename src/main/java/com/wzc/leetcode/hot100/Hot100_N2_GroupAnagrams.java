package com.wzc.leetcode.hot100;

import java.util.*;

public class Hot100_N2_GroupAnagrams {

    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs ={""};
        System.out.println(groupAnagrams(strs));
    }

    /**
     * 方法1:两个互为字母异位词的单词排序后相同，用此做key
     * 方法2:计数，不排序，以计数的结果作为key
       * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // every word sort alphabetically
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
