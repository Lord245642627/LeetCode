package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/6
 * @description LeetCode3040 相同分数的最大操作数目 II
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：
 * 选择 nums 中最前面两个元素并且删除它们。
 * 选择 nums 中最后两个元素并且删除它们。
 * 选择 nums 中第一个和最后一个元素并且删除它们。
 * 一次操作的 分数 是被删除元素的和。
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 */
public class LeetCode3040 {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int res1 = solution(nums, 2, n - 1, nums[0] + nums[1]);
        int res2 = solution(nums, 1, n - 2, nums[0] + nums[n - 1]);
        int res3 = solution(nums, 0, n - 3, nums[n - 1] + nums[n - 2]);
        return Math.max(res1, Math.max(res2, res3)) + 1;
    }

    // dp[i][j] = Math.max(dp[i + 2][j], dp[i + 1][j - 1], dp[i][j - 2]) + 1;
    private int solution(int[] nums, int start, int end, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = end - 1; i >= start; i--) {
            for (int j = i + 1; j <= end; j++) {
                if (nums[i] + nums[i + 1] == target) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i + 2][j + 1] + 1);
                }
                if (nums[i] + nums[j] == target) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j] + 1);
                }
                if (nums[j] + nums[j - 1] == target) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j - 1] + 1);
                }
            }
        }
        return dp[start][end + 1];
    }
}
