package GreedyAlgorithm;

/**
 * @author Lord Camelot
 * @date 2024/3/18
 * @description LeetCode135 分发糖果
 */
public class LeetCode135 {
    // 将「相邻的孩子中，评分高的孩子必须获得更多的糖果」这句话拆分为两个规则，分别处理
    // 左规则：当 ratings[i−1]<ratings[i] {ratings}[i - 1] < {ratings}[i]ratings[i−1]<ratings[i] 时，iii 号学生的糖果数量将比 i−1i - 1i−1 号孩子的糖果数量多
    // 右规则：当 ratings[i]>ratings[i+1] {ratings}[i] > {ratings}[i + 1]ratings[i]>ratings[i+1] 时，iii 号学生的糖果数量将比 i+1i + 1i+1 号孩子的糖果数量多
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + Math.max(left[i], right[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(new LeetCode135().candy(ratings));
    }
}
