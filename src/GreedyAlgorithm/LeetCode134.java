package GreedyAlgorithm;

/**
 * @author Lord Camelot
 * @date 2024/3/18
 * @description LeetCode134 加油站
 */
public class LeetCode134 {
    // 贪心点：若 x 到达不了 y+1，那么 x-y 之间的点也不可能到达 y+1，因为中间任何一点的油都是拥有前面的余量的，所以下次遍历直接从 y+1 开始
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int i = 0;
        while (i < len) {
            int j = 0;
            int cur = 0;
            while (j < len) {
                int n = (i + j) % len;
                cur = cur + gas[n] - cost[n];
                if (cur < 0) {
                    break;
                }
                j++;
            }
            if (j == len) {
                return i;
            } else {
                i = i + j + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(new LeetCode134().canCompleteCircuit(gas, cost));
    }
}
