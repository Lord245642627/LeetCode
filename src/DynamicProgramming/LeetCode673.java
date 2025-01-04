package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/4
 * @description LeetCode673 最长递增子序列的个数
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * 注意 这个数列必须是 严格 递增的。
 */
public class LeetCode673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n], cnt = new int[n] ;
        int cur = 0, res = 0;
        for (int i = 0; i < n; i++) {
            cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > dp[i]) {
                        dp[i] = dp[j];
                        cnt[i] = cnt[j];
                    } else if (dp[j] == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            dp[i]++;
            if (dp[i] > cur) {
                res = cnt[i];
                cur = dp[i];
            } else if(dp[i] == cur) {
                res += cnt[i];
            }
        }
        return res;
    }
}
