package BinarySearch;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/4/26
 * @description LeetCode2517 礼盒的最大甜蜜度
 * 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
 * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
 * 返回礼盒的 最大 甜蜜度。
 */
public class LeetCode2517 {
    // 最大化最小值或最小化最大值一般都是二分答案
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int left = 0, right = (price[price.length - 1] - price[0]) / (k - 1) + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isLess(price, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean isLess(int[] price, int k, int key) {
        int cnt = 1, pre = price[0];
        for (int p : price) {
            if (p >= pre + key) {
                cnt++;
                pre = p;
            }
        }
        return cnt >= k;
    }
}
