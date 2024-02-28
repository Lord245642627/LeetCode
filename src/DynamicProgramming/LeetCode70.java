package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/12/2
 * @description LeetCode70 爬楼梯
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new LeetCode70().climbStairs(n));
    }
}
