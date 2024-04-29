package BinarySearch;

/**
 * @author Lord Camelot
 * @date 2024/4/29
 * @description LeetCode33 搜索旋转排序数组
 *
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (validate(nums, mid, target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    // 当 mid 在 target 右侧时，染蓝色；当 mid 在 target 左侧时，染红色，
    private boolean validate(int[] nums, int i, int target) {
        int end = nums[nums.length - 1];
        if (nums[i] > end) {
            return target > end && nums[i] >= target;
        } else {
            return target > end || nums[i] >= target;
        }
    }
}
