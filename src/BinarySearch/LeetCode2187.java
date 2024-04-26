package BinarySearch;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/4/9
 * @description LeetCode2187 完成旅途的最少时间
 * 给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
 * 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行且互不影响。
 * 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
 */
public class LeetCode2187 {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 0L, right = (long) totalTrips * time[time.length - 1];
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (compute(time, mid) >= totalTrips) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private long compute(int[] time, long t) {
        long total = 0L;
        for (int i = 0; i < time.length; i++) {
            if (time[i] > t) {
                break;
            }
            total += t / time[i];
        }
        return total;
    }
}
