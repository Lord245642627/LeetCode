package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/9/15
 * @description LeetCode131 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串返回 s 所有可能的分割方案。
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), s, 0);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> list, String s, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (isPartition(str)) {
                list.add(str);
                dfs(ans, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPartition(String s) {
        char[] charArray = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
