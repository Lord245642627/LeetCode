package DoublePointer;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/3/28
 * @description LeetCode611 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
public class LeetCode611 {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            int left = 0, right = i- 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
