package leetcode;

import java.util.HashMap;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complementValue = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (complementValue.containsKey(nums[i])) {
                return new int[]{complementValue.get(nums[i]), i};
            }
            complementValue.put(target - nums[i], i);
        }
        // Here it will never come since there is always a solution for this problem as given in problem statement.
        return new int[]{};
    }
}
