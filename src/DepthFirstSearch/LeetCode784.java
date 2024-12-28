package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/11/22
 * @description LeetCode784 字母大小写全排列
 */
public class LeetCode784 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, res, 0);
        return res;
    }

    private void dfs(String s, List<String> res, int index) {
        if (index == s.length()) {
            res.add(s);
            return;
        }
        char[] charArray = s.toCharArray();
        if (!Character.isDigit(charArray[index])) {
            charArray[index] = Character.toLowerCase(charArray[index]);
            dfs(new String(charArray), res, index + 1);
            charArray[index] = Character.toUpperCase(charArray[index]);
            dfs(new String(charArray), res, index + 1);
        } else {
            dfs(new String(charArray), res, index + 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = new LeetCode784().letterCasePermutation("ab");
        System.out.println(res);
    }
}
