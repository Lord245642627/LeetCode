package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2025/1/4
 * @description LeetCode2826 将三个组排序
 * 给你一个整数数组 nums 。nums 的每个元素是 1，2 或 3。在每次操作中，你可以删除 nums 中的一个元素。返回使 nums 成为 非递减 顺序所需操作数的 最小值。
 */
public class LeetCode2826 {
    public int minimumOperations(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.size();
        for (int num : nums) {
            int idx = binarySearch(list, num + 1);
            if (idx == list.size()) {
                list.add(num);
            } else {
                list.set(idx, num);
            }
        }
        return nums.size() - list.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1; // 闭区间 [left, right]
        while (left <= right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right+1] >= target
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1; // 范围缩小到 [mid+1, right]
            } else {
                right = mid - 1; // 范围缩小到 [left, mid-1]
            }
        }
        return left;
    }
}
