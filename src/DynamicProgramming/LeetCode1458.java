package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/3
 * @description LeetCode1458 两个子序列的最大点积
 * 给你两个数组 nums1 和 nums2 。
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 */
public class LeetCode1458 {
    class Solution {
        public int maxDotProduct(int[] nums1, int[] nums2) {
            int l1 = nums1.length, l2 = nums2.length;
            int[][] dp = new int[l1][l2];
            for (int i = 0; i < l1; i++) {
                for (int j = 0; j < l2; j++) {
                    int n = nums1[i] * nums2[j];
                    dp[i][j] = n;
                    if (i > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                    }
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + n);
                    }
                }
            }
            return dp[l1 - 1][l2 - 1];
        }
    }
}
