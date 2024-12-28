package DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lord Camelot
 * @date 2024/3/20
 * @description LeetCode17 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。数字到字母的映射与电话按键相同
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        Map<Character, String> map = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        char[] charArray = digits.toCharArray();
        dfs(charArray, map, 0, new StringBuffer(), res);
        return res;
    }

    private void dfs(char[] charArray, Map<Character, String> map, int index, StringBuffer sb, List<String> res) {
        if (index == charArray.length) {
            res.add(sb.toString());
            return;
        }
        String s = map.get(charArray[index]);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(charArray, map, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = new LeetCode17().letterCombinations(digits);
        res.forEach(System.out::println);
    }
}
