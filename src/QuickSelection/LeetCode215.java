package QuickSelection;

/**
 * @author Lord Camelot
 * @date 2024/3/21
 * @description LeetCode215 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。时间复杂度为 O(n) 的算法解决此问题。
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, n - k, 0, n - 1);
    }

    private int quickSelect(int[] nums, int k, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int pivot = nums[left], i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = pivot;
        if (k > i) {
            return quickSelect(nums, k, i + 1, right);
        } else {
            return quickSelect(nums, k, left, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new LeetCode215().findKthLargest(nums, k));
    }
}
