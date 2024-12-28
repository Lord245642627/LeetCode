package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2023/10/17
 * @description LeetCode22 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuffer(), 0, 0, n);
        return res;

    }

    public void dfs(List<String> res, StringBuffer sb, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            dfs(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> list = new LeetCode22().generateParenthesis(n);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
