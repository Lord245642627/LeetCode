package DailyQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lord
 * @date 2024/12/4
 * @description LeetCode560 和为 K 的子数组
 * 子数组是数组中元素的连续非空序列。
 */
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        // return slidingWindow(nums, k);
        return hash(nums, k);
    }

    private int hash(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.get(sum - k) != null) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    private int slidingWindow(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        for (int start = 0; start < len; start++) {
            int cur = 0;
            for (int end = start; end < len; end++) {
                cur += nums[end];
                if (cur == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
