package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/4
 * @description LeetCode1671 得到山形数组的最少删除次数
 * 我们定义 arr 是 山形数组 当且仅当它满足：
 * arr.length >= 3
 * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
 */
public class LeetCode1671 {
    public int minimumMountainRemovals(int[] nums) {
        // 两个LIS
        int n = nums.length;
        int[] inc = new int[n], dec = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    inc[i] = Math.max(inc[i], inc[j]);
                }
            }
            inc[i]++;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    dec[i] = Math.max(dec[i], dec[j]);
                }
            }
            dec[i]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if (inc[i] == 1 || dec[i] == 1) {
                continue;
            }
            ans = Math.min(ans, n - inc[i] - dec[i] + 1);
        }
        return ans;
    }
}
