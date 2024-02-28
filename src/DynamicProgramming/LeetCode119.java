package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2023/12/6
 * @description LeetCode119 杨辉三角 II
 */
public class LeetCode119 {
    // 动态规划
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(res.get(j - 1) + res.get(j));
                }
            }
            res = temp;
        }
        return res;
    }

    // 数学
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(new LeetCode119().getRow1(rowIndex).toString());
    }
}
