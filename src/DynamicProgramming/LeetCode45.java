package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/12/1
 * @description LeetCode45 跳跃游戏 II
 */
public class LeetCode45 {

    // 方法 1 动态规划
    public int jump1(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                dp[j] = dp[j] == 0 ?  dp[i] + 1 : Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    // 方法 2 贪心算法
    public int jump2(int[] nums) {
        int maxPosition = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                step++;
                end = maxPosition;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new LeetCode45().jump2(nums));
    }
}
