package Backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lord Camelot
 * @date 2024/3/20
 * @description LeetCode17 电话号码的字母组合
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
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
        backtrack(charArray, map, 0,  new StringBuffer(), res);
        return res;
    }

    private void backtrack(char[] charArray, Map<Character, String> map, int index, StringBuffer sb, List<String> res) {
        if (index == charArray.length) {
            res.add(sb.toString());
            return;
        }
        String s = map.get(charArray[index]);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtrack(charArray, map, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = new LeetCode17().letterCombinations(digits);
        res.forEach(System.out::println);
    }
}
