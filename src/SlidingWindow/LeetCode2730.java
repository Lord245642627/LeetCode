package SlidingWindow;

/**
 * @author Lord Camelot
 * @date 2024/4/1
 * @description LeetCode2730 找到最长的半重复子字符串
 * 给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
 * 如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。例如，0010 、002020 、0123 、2002 和 54944 是半重复字符串，而 00101022 和 1101234883 不是。
 * 请你返回 s 中最长 半重复 子字符串的长度。
 * 一个 子字符串 是一个字符串中一段连续 非空 的字符。
 */
public class LeetCode2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 1;
        int n = s.length();
        if (n == 1) {
            return ans;
        }
        int left = 0;
        int same = 0;
        for (int right = 1; right < n; right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                same++;
                while (same == 2) {
                    left++;
                    // 当移动到前后两个位置相同的时候，说明当前子字符串中的重复子串数量减一
                    if (s.charAt(left) == s.charAt(left - 1)) {
                        same--;
                    }
                }
            }
            ans = Math.max(ans, right - left + 1);

        }
        return ans;
    }
}
