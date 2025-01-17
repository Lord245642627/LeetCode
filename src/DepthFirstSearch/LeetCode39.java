package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/12/20
 * @description LeetCode39 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }


    private void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            list.add(num);
            dfs(res, list, candidates, target - num, i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode39 leetcode39 = new LeetCode39();
        System.out.println(leetcode39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
