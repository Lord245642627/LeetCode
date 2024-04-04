package BinarySearch;

/**
 * @author Lord Camelot
 * @date 2024/4/4
 * @description LeetCode34 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LeetCode34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = lowerBound(nums, target); // 选择其中一种写法即可
            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1};
            }
            // 如果 start 存在，那么 end 必定存在
            int end = lowerBound(nums, target + 1) - 1;
            return new int[]{start, end};
        }

        // lowerBound 返回最小的满足 nums[i] >= target 的 i
        // 如果数组为空，或者所有数都 < target，则返回 nums.length
        // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]

        // 闭区间写法
        private int lowerBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1; // 闭区间 [left, right]
            while (left <= right) { // 区间不为空
                // 循环不变量：
                // nums[left-1] < target
                // nums[right+1] >= target
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1; // 范围缩小到 [mid+1, right]
                } else {
                    right = mid - 1; // 范围缩小到 [left, mid-1]
                }
            }
            return left;
        }

        // 左闭右开区间写法
        private int lowerBound2(int[] nums, int target) {
            int left = 0, right = nums.length; // 左闭右开区间 [left, right)
            while (left < right) { // 区间不为空
                // 循环不变量：
                // nums[left-1] < target
                // nums[right] >= target
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1; // 范围缩小到 [mid+1, right)
                } else {
                    right = mid; // 范围缩小到 [left, mid)
                }
            }
            return left; // 返回 left 还是 right 都行，因为循环结束后 left == right
        }

        // 开区间写法
        private int lowerBound3(int[] nums, int target) {
            int left = -1, right = nums.length; // 开区间 (left, right)
            while (left + 1 < right) { // 区间不为空
                // 循环不变量：
                // nums[left] < target
                // nums[right] >= target
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid; // 范围缩小到 (mid, right)
                } else {
                    right = mid; // 范围缩小到 (left, mid)
                }
            }
            return right;
        }
    }
}
