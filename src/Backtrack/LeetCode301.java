package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/12/20
 * @description LeetCode301 删除无效的括号
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 */
public class LeetCode301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int openRemove = 0, closeRemove = 0;
        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i) == '(') {
                openRemove++;
            } else if (s.charAt(i) == ')') {
                if (openRemove == 0) {
                    closeRemove++;
                } else {
                    openRemove--;
                }
            }
        }
        dfs(res, s, 0, openRemove, closeRemove);
        return res;
    }

    private void dfs(List<String> res, String s, int start, int openRemove, int closeRemove) {
        if (openRemove == 0 && closeRemove == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 去重
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (openRemove + closeRemove > s.length() - i) {
                return;
            }
            if (openRemove > 0 && s.charAt(i) == '(') {
                dfs(res, s.substring(0, i) + s.substring(i + 1), i, openRemove - 1, closeRemove);
            }
            if (closeRemove > 0 && s.charAt(i) == ')') {
                dfs(res, s.substring(0, i) + s.substring(i + 1), i, openRemove, closeRemove - 1);
            }
        }
    }

    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
