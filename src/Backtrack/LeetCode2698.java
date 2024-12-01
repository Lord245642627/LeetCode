package Backtrack;

/**
 * @author lord
 * @date 2024/12/1
 * @description LeetCode2698 求一个整数的惩罚数
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 */
public class LeetCode2698 {
    public int punishmentNumber(int n) {
        // return enumeration(n);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i * i, i)) {
                res += Math.pow(i, 2);
            }
        }
        return res;
    }

    // 枚举
    private int enumeration(int n) {
        int[] list = {1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991, 999, 1000};
        int res = 0;
        for (int i : list) {
            if (i > n) {
                break;
            }
            res += Math.pow(i, 2);
        }
        return res;
    }

    // 递归
    private boolean isValid(int s, int n) {
        if (s < n) {
            return false;
        }
        if (s == n) {
            return true;
        }
        for (int i = 10; i <= s; i *= 10) {
            if (isValid(s / i, n - s % i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2698().punishmentNumber(10));
    }
}
