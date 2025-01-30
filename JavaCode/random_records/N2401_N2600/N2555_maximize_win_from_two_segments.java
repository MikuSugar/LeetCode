package JavaCode.random_records.N2401_N2600;

import utils.CheckUtil;
import utils.Parse;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mikusugar
 * @version 1.0, 2024/9/11 17:07
 * @description maximize-win-from-two-segments
 */
public class N2555_maximize_win_from_two_segments {
    public static void main(String[] args) {
        final N2555_maximize_win_from_two_segments solve = new N2555_maximize_win_from_two_segments();
        CheckUtil.check(7, solve.maximizeWin(Parse.toIntArr("[1,1,2,2,3,3,5]"), 2));
    }

    public int maximizeWin(int[] prizePositions, int k) {
        int[] add = new int[prizePositions[prizePositions.length - 1]+1];
        for (int i = 0; i < prizePositions.length; i++) {
            add[prizePositions[i]]++;
        }

        int[] sum = new int[add.length + 1];
        for (int i = 0; i < add.length; i++) {
            sum[i + 1] = sum[i] + add[i];
        }
        int[][] arr = new int[add.length][2];
        for (int i = k; i < add.length; i++) {
            arr[i][0] = i;
            arr[i][1] = sum[i + 1] - sum[i - k];
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        int res = 0;
        boolean[] book = new boolean[add.length];
        for (int i = arr[arr.length - 1][0]; i >= arr[arr.length - 1][0] - k; i--) {
            book[i] = true;
            res += add[i];
        }
        for (int i = arr[arr.length - 2][0]; i >= arr[arr.length - 1][0] - k; i--) {
            if (book[i]) continue;
            res += add[i];
        }
        return res;
    }
}
/*
在 X轴 上有一些奖品。给你一个整数数组 prizePositions ，它按照 非递减 顺序排列，其中 prizePositions[i] 是第 i 件奖品的位置。数轴上一个位置可能会有多件奖品。再给你一个整数 k 。

你可以同时选择两个端点为整数的线段。每个线段的长度都必须是 k 。你可以获得位置在任一线段上的所有奖品（包括线段的两个端点）。注意，两个线段可能会有相交。

比方说 k = 2 ，你可以选择线段 [1, 3] 和 [2, 4] ，你可以获得满足 1 <= prizePositions[i] <= 3 或者 2 <= prizePositions[i] <= 4 的所有奖品 i 。
请你返回在选择两个最优线段的前提下，可以获得的 最多 奖品数目。



示例 1：

输入：prizePositions = [1,1,2,2,3,3,5], k = 2
输出：7
解释：这个例子中，你可以选择线段 [1, 3] 和 [3, 5] ，获得 7 个奖品。
示例 2：

输入：prizePositions = [1,2,3,4], k = 0
输出：2
解释：这个例子中，一个选择是选择线段 [3, 3] 和 [4, 4] ，获得 2 个奖品。


提示：

1 <= prizePositions.length <= 105
1 <= prizePositions[i] <= 109
0 <= k <= 109
prizePositions 有序非递减。
 */
