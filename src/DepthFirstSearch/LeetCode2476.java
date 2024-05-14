package DepthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/5/14
 * @description LeetCode2476 二叉搜索树最近节点查询
 */
public class LeetCode2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<Integer>();
        dfs(root, arr);

        List<List<Integer>> ans = new ArrayList();
        for (int query : queries) {
            int maxVal = -1, minVal = -1;
            int idx = binarySearch(arr, query);
            // 若查询到了大于等于目标值的最小值，则更改 maxVal 的信息
            if (idx != arr.size()) {
                maxVal = arr.get(idx);
                // 若该值等于目标值，则小于等于目标值的最大值也为目标值本身
                if (maxVal == query) {
                    minVal = query;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(minVal);
                    list.add(maxVal);
                    ans.add(list);
                    continue;
                }
            }
            // 无论是否查询到大于等于目标值的最小值，所得结果的前一个都必定为小于等于目标值的最大值
            if (idx > 0) {
                minVal = arr.get(idx - 1);
            }
            List<Integer> list = new ArrayList<Integer>();
            list.add(minVal);
            list.add(maxVal);
            ans.add(list);
        }
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }

    private int binarySearch(List<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
