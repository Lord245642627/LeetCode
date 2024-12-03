package DailyQuestion;

/**
 * @author lord
 * @date 2024/12/3
 * @description LeetCode3274 检查棋盘方格颜色是否相同
 * 给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。
 * 如果这两个方格颜色相同，返回 true，否则返回 false。
 * 坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。
 */
public class LeetCode3274 {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        // int a = (coordinate1.charAt(0) - 'a' + coordinate1.charAt(1) - '0' + 1) % 2;
        // int b = (coordinate2.charAt(0) - 'a' + coordinate2.charAt(1) - '0' + 1) % 2;
        // return a == b;
        return (coordinate1.charAt(0) - coordinate2.charAt(0) + coordinate1.charAt(1) - coordinate2.charAt(1)) % 2 == 0;
    }
}
