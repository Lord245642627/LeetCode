package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/12/1
 * @description LeetCode94 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class LeetCode94 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return result;
    }
    public void backtracking(StringBuilder s, int startIndex, int pointNum) {
        if(pointNum == 3) { // 终止条件
            if(isValid(s, startIndex, s.length() - 1)) {
                result.add(s.toString());
            }
            return;
        }
        for(int i = startIndex; i < s.length(); i++) {
            if(isValid(s, startIndex, i)) { // 判断[startIndex, i]这个区间的子串是否合法
                s.insert(i + 1, '.'); // 在i+1的位置添加分隔符点
                pointNum++;
                backtracking(s, i + 2, pointNum); // 递归
                pointNum--; // 回溯
                s.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }
    public boolean isValid(StringBuilder s, int start, int end) {
        if(start > end)
            return false;

        if(s.charAt(start) == '0' && start != end) // 以0开头的数字不合法
            return false;

        int num = 0;
        for(int i = start; i <= end; i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if(num > 255) { // 如果大于255了不合法
                return false;
            }
        }
        return true;
    }
}
