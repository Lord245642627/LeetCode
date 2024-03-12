package BinarySearch;

/**
 * @author Lord Camelot
 * @date 2024/3/12
 * @description
 */
public class BinarySearch {
    private int binarySearch(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid - 1, target);
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;
        System.out.println(new BinarySearch().binarySearch(nums, target));
    }
}
