package Array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lord
 * @date 2024/11/21
 * @description
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
