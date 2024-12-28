package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/11/29
 * @description LeetCode1239 串联字符串的最大长度
 * 给定一个字符串数组 arr，字符串 s 是将 arr 的含有 不同字母 的 子序列 字符串 连接 所得的字符串。
 * 请返回所有可行解 s 中最长长度。
 * 子序列 是一种可以从另一个数组派生而来的数组，通过删除某些元素或不删除元素而不改变其余元素的顺序。
 */
public class LeetCode1239 {
    private int res = 0;
    public int maxLength(List<String> arr) {
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (!isContain(s)) {
                list.add(s);
            }
        }
        dfs(list, 0, "");
        return res;
    }

    private void dfs(List<String> list, int index, String s) {
        if (index == list.size()) {
            res = Math.max(res, s.length());
            return;
        }
        dfs(list, index + 1, s);
        String str = s + list.get(index);
        if (!isContain(str)) {
            dfs(list, index + 1, str);
        }
    }

    private boolean isContain(String str) {
        int[] table = new int[27];
        char[] charArray = str.toCharArray();
        for (char c :charArray) {
            int i = c - 'a';
            if (table[i] != 0) {
                return true;
            }
            table[i]++;
        }
        return false;
    }
}
