package DailyQuestion;

/**
 * @author lord
 * @date 2024/12/13
 * @description LeetCode3264 K 次乘运算后的最终数组 I
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 * 你需要对 nums 执行 k 次操作，每次操作中：
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * 请你返回执行完 k 次乘运算之后，最终的 nums 数组。
 */
public class LeetCode3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            nums[index] *= multiplier;
            min = Integer.MAX_VALUE;
        }
        return nums;
    }
}
