package DoublePointer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/3/26
 * @description LeetCode2824 统计和小于目标的下标对数目
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 */
public class LeetCode2824 {
    public int countPairs(List<Integer> nums, int target) {
        nums.sort(null);
        int left = 0, right = nums.size() - 1;
        int ans = 0;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum >= target) {
                right--;
            } else {
                ans += right - left;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-1,1,2,3,1);
        int target = 2;
        System.out.println(new LeetCode2824().countPairs(nums, target));
    }
}
