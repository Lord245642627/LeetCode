package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lord
 * @date 2024/12/27
 * @description LeetCode46 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs1(nums, res, 0);
        return res;

//        List<List<Integer>> res = new ArrayList<>();
//        List list = Arrays.asList(new Integer[nums.length]);
//        dfs2(nums, res, list, new boolean[nums.length], 0);
//        return res;
    }


    private void dfs1(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
//            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs1(nums, res, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void dfs2(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] selected, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (selected[i] == false) {
                selected[i] = true;
                list.set(index, nums[i]);
                dfs2(nums, res, list, selected, index + 1);
                selected[i] = false;
            }
        }
    }
}
