package JavaCode.random_records.N701_800;

import java.util.Arrays;

public class N799_champagne_tower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_glass + 2];
        for (int i=0;i<=query_row;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=poured;
        double res=slove(query_row,query_glass,dp)/1.0;
        return res>1?1:res;
    }

    private double slove(int i, int j,double[][]dp) {
        if(i<0||j<0)return 0d;
        if(dp[i][j]!=-1)return dp[i][j];
        double left=slove(i-1,j-1,dp);
        double right=slove(i-1,j,dp);
        left=left>1?left-1d:0d;
        right=right>1?right-1d:0d;
        return dp[i][j]=left*.5+right*.5;
    }
}
/**
 * 我们把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层，每个玻璃杯(250ml)将盛有香槟。
 *
 * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
 *
 * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
 *
 *
 *
 * 现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（i 和 j都从0开始）。
 *
 *  
 *
 * 示例 1:
 * 输入: poured(倾倒香槟总杯数) = 1, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 * 输出: 0.0
 * 解释: 我们在顶层（下标是（0，0））倒了一杯香槟后，没有溢出，因此所有在顶层以下的玻璃杯都是空的。
 *
 * 示例 2:
 * 输入: poured(倾倒香槟总杯数) = 2, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 * 输出: 0.5
 * 解释: 我们在顶层（下标是（0，0）倒了两杯香槟后，有一杯量的香槟将从顶层溢出，位于（1，0）的玻璃杯和（1，1）的玻璃杯平分了这一杯香槟，所以每个玻璃杯有一半的香槟。
 * 注意:
 *
 * poured 的范围[0, 10 ^ 9]。
 * query_glass 和query_row 的范围 [0, 99]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/champagne-tower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
