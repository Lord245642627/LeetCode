package BinarySearch;

/**
 * @author Lord Camelot
 * @date 2024/4/30
 * @description LeetCode154 寻找旋转排序数组中的最小值 II
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须尽可能减少整个过程的操作步骤。
 */
public class LeetCode154 {
    public int findMin(int[] nums) {
        // 此处设置 right=nums.length-2 原因有 2，一是 nums[nums.length-1] 必定大于等于最小值，二是保证 right+1 始终大于等于最小值
        int left = 0; int right = nums.length - 2, end = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 此处设置 nums[mid]<nums[right+1] 的原因为设置 right=mid-1 时 nums[right] 的大小暂时未知，而 nums[right+1] 一定大于等于最小值
            if (nums[mid] < nums[right + 1]) {
                right = mid - 1;
            } else if (nums[mid] > nums[right + 1]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
