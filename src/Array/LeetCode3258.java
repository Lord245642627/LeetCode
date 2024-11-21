package Array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lord
 * @date 2024/11/21
 * @description LeetCode3258 矩阵中的蛇
 * 大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i * n) + j。
 * 蛇从单元格 0 开始，并遵循一系列命令移动。
 * 给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，其中包括 "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。
 * 返回执行 commands 后蛇所停留的最终单元格的位置。
 */
public class LeetCode3258 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        Map<String, Integer> map = new HashMap<>();
        map.put("UP", -n);
        map.put("RIGHT", 1);
        map.put("DOWN", n);
        map.put("LEFT", -1);
        int res = 0;
        for (String s : commands) {
            res += map.get(s);
        }
        return res;
    }

    public int solution(int n, List<String> commands) {
        int res = 0;
        for (String command : commands) {
            switch (command) {
                case "RIGHT":
                    res++;
                    break;
                case "LEFT":
                    res--;
                    break;
                case "UP":
                    res -= n;
                    break;
                case "DOWN":
                    res += n;
                    break;
            }
        }
        return res;
    }
}
