package DynamicProgramming;

/**
 * @author lord
 * @date 2024/12/29
 * @description LeetCode213 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        int len = nums.length;
        return Math.max(nums[0] + rob1(nums, 2, len - 1), rob1(nums, 1, len));
    }

    private int rob1(int[] nums, int start, int end) {
        int p = 0, q = 0;
        for (int i = start; i < end; i++) {
            int r = Math.max(p + nums[i], q);
            p = q;
            q = r;
        }
        return q;
    }
}
