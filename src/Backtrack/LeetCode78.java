package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/9/15
 * @description LeetCode78 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        dfs2(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    private void dfs1(List<List<Integer>> ans, List<Integer> list, int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs1(ans, list, index + 1, nums);
        list.add(nums[index]);
        dfs1(ans, list, index + 1, nums);
        list.remove(list.size() - 1);
    }

    private void dfs2(List<List<Integer>> ans, List<Integer> list, int index, int[] nums) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs2(ans, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new LeetCode78().subsets(nums));
    }
}
