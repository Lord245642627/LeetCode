package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/11/29
 * @description LeetCode42 接雨水
 */
public class LeetCode42 {
    public int trap(int[] height) {
        int res = 0;
        // 若数组为空或数组的长度小于 3，则无法接到雨水，直接返回 0；
        if (height == null || height.length < 3) {
            return res;
        }
        // 建立左边最高的墙的数组和右边最高的墙的数组，则当前列能够接到的雨水 = Math.max(Math.min(left[i], right[i]) - height[i], 0)
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int leftHighest = 0;
        for (int i = 0; i < height.length; i++) {
            left[i] = leftHighest;
            leftHighest = Math.max(height[i], leftHighest);
        }

        int rightHighest = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = rightHighest;
            rightHighest = Math.max(height[i], rightHighest);
        }

        for (int i = 0; i < height.length; i++) {
            int temp = Math.max(Math.min(left[i], right[i]) - height[i], 0);
            res += temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new LeetCode42().trap(height));
    }
}
