package BinarySearch;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/4/4
 * @description LeetCode2300 咒语和药水的成功对数
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 */
public class LeetCode2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            long target = (success - 1) / spells[i];
            // 若 target 比 potions 中最大的值还大，说明没有满足要求的值，因此直接设为 0；
            if (target < potions[potions.length - 1]) {
                ans[i] = potions.length - upperBound(potions, (int) target);
            }
        }
        return ans;
    }

    private int upperBound(int[] potions, int target) {
        int left = 0, right = potions.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
