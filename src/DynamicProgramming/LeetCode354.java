package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lord
 * @date 2025/1/4
 * @description LeetCode354 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 */
public class LeetCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        // 将排序的第二关键字进行降序排序，使得相同长度的信封，宽不存在递增子序列，从而消除等于的情况
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = envelopes.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = binarySearch(list, envelopes[i][1]);
            if (idx == list.size()) {
                list.add(envelopes[i][1]);
            } else {
                list.set(idx, envelopes[i][1]);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
