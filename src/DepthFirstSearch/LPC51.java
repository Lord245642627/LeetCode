package DepthFirstSearch;

/**
 * @author lord
 * @date 2024/11/22
 * @description LCP 51. 烹饪料理
 * 欢迎各位勇者来到力扣城，城内设有烹饪锅供勇者制作料理，为自己恢复状态。
 * 勇者背包内共有编号为 0 ~ 4 的五种食材，其中 materials[j] 表示第 j 种食材的数量。通过这些食材可以制作若干料理，cookbooks[i][j] 表示制作
 * 第 i 种料理需要第 j 种食材的数量，而 attribute[i] = [x,y] 表示第 i 道料理的美味度 x 和饱腹感 y。
 * 在饱腹感不小于 limit 的情况下，请返回勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 -1。
 * 注意：
 * 每种料理只能制作一次。
 */
public class LPC51 {
    int res = -1;
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        dfs(materials, cookbooks, attribute, limit, 0, 0);
        return res;
    }

    private void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int limit, int index, int cur) {
        if (index == cookbooks.length) {
            if (limit <= 0) {
                res = Math.max(res, cur);
            }
            return;
        }
        dfs(materials, cookbooks, attribute, limit, index + 1, cur);
        if (isEnough(materials, cookbooks, index)) {
            for (int i = 0; i < materials.length; i++) {
                materials[i] -= cookbooks[index][i];
            }
            cur += attribute[index][0];
            limit -= attribute[index][1];
            dfs(materials, cookbooks, attribute, limit, index + 1, cur);
            for (int i = 0; i < materials.length; i++) {
                materials[i] += cookbooks[index][i];
            }
        }
    }

    private boolean isEnough(int[] materials, int[][] cookbooks, int index) {
        for (int i = 0; i < materials.length; i++) {
            if (materials[i] < cookbooks[index][i]) {
                return false;
            }
        }
        return true;
    }
}
