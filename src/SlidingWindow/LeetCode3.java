package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lord Camelot
 * @date 2024/3/25
 * @description LeetCode3 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.get(s.charAt(right)) != null) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new LeetCode3().lengthOfLongestSubstring(s));
    }
}
