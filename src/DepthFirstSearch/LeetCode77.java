package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/12/13
 * @description LeetCode77 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int n, int k, int index, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index > n) {
            return;
        }
        list.add(index);
        dfs(n, k, index + 1, res, list);
        list.remove(list.size() - 1);
        dfs(n, k, index + 1, res, list);
    }
}
