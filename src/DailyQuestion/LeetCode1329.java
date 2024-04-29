package DailyQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/4/29
 * @description
 */
public class LeetCode1329 {
    public int[][] diagonalSort(int[][] mat) {
        for (int i = mat[0].length - 1; i >= 0; i--) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < mat.length; j++) {
                int k = i + j;
                if (k >= mat[0].length) {
                    break;
                }
                list.add(mat[j][k]);
            }
            Collections.sort(list);
            for (int j = 0; j < mat.length; j++) {
                int k = i + j;
                if (k >= mat[0].length) {
                    break;
                }
                mat[j][k] = list.get(j);
            }
        }
        for (int i = mat.length - 1; i >= 0; i--) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < mat[0].length; j++) {
                int k = i + j;
                if (k >= mat.length) {
                    break;
                }
                list.add(mat[k][j]);
            }
            Collections.sort(list);
            for (int j = 0; j < mat[0].length; j++) {
                int k = i + j;
                if (k >= mat.length) {
                    break;
                }
                mat[k][j] = list.get(j);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        new LeetCode1329().diagonalSort(mat);
    }
}
