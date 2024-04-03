package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lord Camelot
 * @date 2024/4/3
 * @description LeetCode76 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        int min = s.length() + 1;
        int left = 0;
        int start = 0, end = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }
            while (check(map)) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    start = left;
                    end = right + 1;
                }
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }
                left++;
            }
        }
        return min > s.length() ? "" : s.substring(start, end);
    }

    private boolean check(Map<Character, Integer> map) {
        for (int count : map.values()) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}
