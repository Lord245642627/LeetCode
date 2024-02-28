package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/12/2
 * @description LeetCode53 最大子数组和
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int maxAns = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            maxAns = Math.max(maxAns, temp);
            temp = Math.max(temp, 0);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new LeetCode53().maxSubArray(nums));
    }
}
