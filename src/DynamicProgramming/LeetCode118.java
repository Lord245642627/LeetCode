package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2023/12/6
 * @description LeetCode 杨辉三角
 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(new LeetCode118().generate(numRows).toString());
    }
}
