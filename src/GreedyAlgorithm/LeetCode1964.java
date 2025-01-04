package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2025/1/4
 * @description LeetCode1964 找出到每个位置为止最长的有效障碍赛跑路线
 * 你打算构建一些障碍赛跑路线。给你一个 下标从 0 开始 的整数数组 obstacles ，数组长度为 n ，其中 obstacles[i] 表示第 i 个障碍的高度。
 * 对于每个介于 0 和 n - 1 之间（包含 0 和 n - 1）的下标  i ，在满足下述条件的前提下，请你找出 obstacles 能构成的最长障碍路线的长度：
 * 你可以选择下标介于 0 到 i 之间（包含 0 和 i）的任意个障碍。
 * 在这条路线中，必须包含第 i 个障碍。
 * 你必须按障碍在 obstacles 中的 出现顺序 布置这些障碍。
 * 除第一个障碍外，路线中每个障碍的高度都必须和前一个障碍 相同 或者 更高 。
 * 返回长度为 n 的答案数组 ans ，其中 ans[i] 是上面所述的下标 i 对应的最长障碍赛跑路线的长度。
 */
public class LeetCode1964 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] res = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = obstacles[i];
            int idx = binarySearch(list, num + 1);
            if (idx == list.size()) {
                list.add(num);
            } else {
                list.set(idx, num);
            }
            res[i] = idx + 1;
        }
        return res;
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1; // 闭区间 [left, right]
        while (left <= right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right+1] >= target
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1; // 范围缩小到 [mid+1, right]
            } else {
                right = mid - 1; // 范围缩小到 [left, mid-1]
            }
        }
        return left;
    }
}
