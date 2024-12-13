package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/12/13
 * @description LeetCode216 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 0, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int n, int sum, int index) {
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = index; i < 10; i++) {
            sum += i;
            list.add(i);
            dfs(res, list, k, n, sum, i + 1);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(new LeetCode216().combinationSum3(k, n));
    }
}
