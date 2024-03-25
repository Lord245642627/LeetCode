package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/3/24
 * @description LeetCode15 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 顺序无关时，可以对集合进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 时间效率优化1: 若前三个已大于0，则不可能再存在等于0的序列
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            // 时间效率优化2: 若当前数与最后两个数已小于0，则该数存在的序列不可能等于0，直接进行下一个数的查找
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        new LeetCode15().threeSum(nums);
    }
}
