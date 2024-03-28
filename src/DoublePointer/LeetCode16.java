package DoublePointer;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/3/26
 * @description LeetCode16 最接近的三数之和
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    if (target - sum < min) {
                        ans = sum;
                        min = target - sum;
                    }
                    left++;
                } else {
                    if (sum - target < min) {
                        ans = sum;
                        min = sum - target;
                    }
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new LeetCode16().threeSumClosest(nums, target));
    }
}
