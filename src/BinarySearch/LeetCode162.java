package BinarySearch;

/**
 * @author Lord Camelot
 * @date 2024/4/29
 * @description LeetCode162 寻找峰值
 *
 */
public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        // 由于 n-1 一定是 峰值 或 在峰值右侧，所以为了防止溢出，排掉它。
        int left = 0, right = nums.length - 2;
        // 二分查找本质是查找不确定区间。（无论true还是false都是确定的）
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 将 mid 与 mid+1 做比较，若 nums[mid] > nums[mid + 1]，表示 nums[mid] 要么为峰值，要么为峰值右侧数据
            // 否则，说明 nums[mid] 一定为峰值左侧的数据。因此，最后返回 left 位置的数据。
            if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
