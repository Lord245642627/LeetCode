package Backtrack;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/12/1
 * @description LeetCode2212 射箭比赛中的最大得分
 * Alice 和 Bob 是一场射箭比赛中的对手。比赛规则如下：
 * Alice 先射 numArrows 支箭，然后 Bob 也射 numArrows 支箭。
 * 分数按下述规则计算：
 * 箭靶有若干整数计分区域，范围从 0 到 11 （含 0 和 11）。
 * 箭靶上每个区域都对应一个得分 k（范围是 0 到 11），Alice 和 Bob 分别在得分 k 区域射中 ak 和 bk 支箭。如果 ak >= bk ，那么 Alice 得 k 分。如果 ak < bk ，则 Bob 得 k 分
 * 如果 ak == bk == 0 ，那么无人得到 k 分。
 * 例如，Alice 和 Bob 都向计分为 11 的区域射 2 支箭，那么 Alice 得 11 分。如果 Alice 向计分为 11 的区域射 0 支箭，但 Bob 向同一个区域射 2 支箭，那么 Bob 得 11 分。
 * 给你整数 numArrows 和一个长度为 12 的整数数组 aliceArrows ，该数组表示 Alice 射中 0 到 11 每个计分区域的箭数量。现在，Bob 想要尽可能 最大化 他所能获得的总分。
 * 返回数组 bobArrows ，该数组表示 Bob 射中 0 到 11 每个 计分区域的箭数量。且 bobArrows 的总和应当等于 numArrows 。
 * 如果存在多种方法都可以使 Bob 获得最大总分，返回其中 任意一种 即可。
 */
public class LeetCode2212 {
    int maxScore = 0;
    int[] res;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        // return binaryEnumeration(numArrows, aliceArrows);
        res = new int[12];
        backtrack(numArrows, aliceArrows, 0, 0, new int[12]);
        return res;
    }

    private void backtrack(int numArrows, int[] aliceArrows, int index, int score, int[] bobArrows) {
        if (index == aliceArrows.length) {
            if (score > maxScore) {
                maxScore = score;
                bobArrows[0] += numArrows;
                res = Arrays.copyOf(bobArrows, bobArrows.length);
                bobArrows[0] -= numArrows;
            }
            return;
        }
        backtrack(numArrows, aliceArrows, index + 1, score, bobArrows);
        if (numArrows > aliceArrows[index]) {
            score += index;
            numArrows -= (aliceArrows[index] + 1);
            bobArrows[index] += (aliceArrows[index] + 1);
            backtrack(numArrows, aliceArrows, index + 1, score, bobArrows);
            score -= index;
            numArrows += (aliceArrows[index] + 1);
            bobArrows[index] = 0;
        }
    }

    // 二进制枚举法
    private int[] binaryEnumeration(int numArrows, int[] aliceArrows) {
        int n = 12;
        int maxScore = 0;
        int[] res = new int[n];

        for (int i = 0; i < 1 << n; i++) { // 即i < 2^12
            // 用i来表示每一次结果，i 是一个 12 位的二进制串，如 100000000011 表示第0、1、11个区域获胜，其他区域都失败
            int score = 0;
            int usedArrows = 0;
            int[] bobArrows = new int[n];
            for (int j = 0; j < 12; j++) {
                if ((i >> j & 1) == 1) {
                    score += j;
                    usedArrows += aliceArrows[j] + 1;
                    bobArrows[j] = aliceArrows[j] + 1;
                }
            }
            if (usedArrows > numArrows) {
                continue;
            }
            if (score > maxScore) {
                maxScore =score;
                bobArrows[0] += (numArrows - usedArrows);
                res = bobArrows;
            }
        }
        return res;
    }
}
