package DailyQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/12/27
 * @description LeetCode3159 查询数组中元素的出现位置
 */
public class LeetCode3159 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                list.add(i);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = queries[i] <= list.size() ? list.get(queries[i] - 1) : -1;
        }
        return res;
    }
}
