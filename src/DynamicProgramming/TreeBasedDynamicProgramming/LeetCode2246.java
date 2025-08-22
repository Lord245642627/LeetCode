package DynamicProgramming.TreeBasedDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2025/1/23
 * @description LeetCode2246 相邻字符不同的最长路径
 */
public class LeetCode2246 {
    List<Integer>[] g;
    char[] s;
    private int ans;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        this.s = s.toCharArray();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }
        dfs(0);
        return ans + 1;
    }

    private int dfs(int x) {
        int maxLen = 0;
        for (int y : g[x]) {
            int len = dfs(y) + 1;
            if (s[x] != s[y]) {
                ans = Math.max(ans, maxLen + len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
