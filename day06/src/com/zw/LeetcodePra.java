package com.zw;

import org.testng.annotations.Test;

import java.util.*;

/**
 * <p> LeetCodePra </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/20 22:00
 */
public class LeetcodePra {

    @Test
    public void test() {
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums2 = {};
//        System.out.println("longestConsecutive(nums) = " + longestConsecutive2(nums2));

        String s = "abcdefghijklmn";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c+":"+(int)c);
        }
    }


    /**
     * 每日一题 移动零
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 每日一题 字母异位词分组
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        //遍历字符串分组
        for (String str : strs) {
            int[] nums = new int[26];
            for (int i = 0; i < str.length(); i++) {
                nums[str.charAt(i) - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (nums[i] != 0) {
                    builder.append((char) 'a' + i);
                    builder.append(nums[i]);
                }
            }
            String key = builder.toString();
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        //打印结果
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    /**
     * 每日做题
     * 最长连续序列
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = Integer.MIN_VALUE;
        int size = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == (nums[i - 1] + 1)) {
                size++;
                result = Math.max(size, result);
            } else {
                size = 0;
            }
        }
        return result == Integer.MIN_VALUE ? 0 : result + 1;
    }

    /**
     * 每日做题
     * 最长连续序列 哈希法
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int num : nums) {
            list.add(num);
        }

        int result = 0;
        for (int num : nums) {
            //判断是否是起点
            if (!list.contains(num - 1)) {
                int currentNum = num;
                int temp = 0;
                while (list.contains(currentNum++)) {
                    temp++;
                }
                result = Math.max(result, temp);
            }
        }
        return result;
    }
}
