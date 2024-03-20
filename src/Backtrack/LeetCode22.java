package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2023/10/17
 * @description LeetCode22 括号生成
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuffer(), 0, 0, n);
        return res;

    }

    public void backtrack(List<String> res, StringBuffer sb, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            backtrack(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            backtrack(res, sb, left, right + 1, n);
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
