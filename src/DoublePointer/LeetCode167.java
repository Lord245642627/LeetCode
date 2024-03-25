package DoublePointer;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/3/24
 * @description LeetCode167 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 所设计的解决方案必须只使用常量级的额外空间。
 */
public class LeetCode167 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            if (nums[left] + nums[right] < target){
                left++;
            } else if (nums[left] + nums[right] > target){
                right--;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new LeetCode167().twoSum(numbers, target)));
    }
}
