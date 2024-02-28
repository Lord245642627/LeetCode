package GreedyAlgorithm;

/**
 * @author Lord Camelot
 * @date 2023/12/2
 * @description LeetCode55 跳跃游戏
 */
public class LeetCode55 {
    // 贪心算法
    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPosition) {
                return false;
            }
            maxPosition = Math.max(i + nums[i], maxPosition);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(new LeetCode55().canJump(nums));
    }
}
