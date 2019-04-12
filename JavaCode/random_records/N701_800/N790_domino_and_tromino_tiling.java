package JavaCode.random_records.N701_800;

import com.sun.org.apache.xpath.internal.operations.Mod;

public class N790_domino_and_tromino_tiling {

    static int MOD=(int) (1e9+7);
    public int numTilings(int N) {
        long[] dp1=new long[N+1];//没有突出的情况
        long[] dp2=new long[N+1];//有突出的情况
        dp1[0]=dp1[1]=1;
        dp2[0]=dp2[1]=0;
        for (int i=2;i<=N;i++)
        {
            dp1[i]=(dp1[i-1]%MOD+dp1[i-2]%MOD+dp2[i-1]*2%MOD)%MOD;
            dp2[i]=(dp1[i-2]%MOD+dp2[i-1]%MOD)%MOD;
        }
        return (int) dp1[N];
    }
}
/**
 * 有两种形状的瓷砖：一种是 2x1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 *
 * XX  <- 多米诺
 *
 * XX  <- "L" 托米诺
 * X
 * 给定 N 的值，有多少种方法可以平铺 2 x N 的面板？返回值 mod 10^9 + 7。
 *
 * （平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。）
 *
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 下面列出了五种不同的方法，不同字母代表不同瓷砖：
 * XYZ XXZ XYY XXY XYY
 * XYZ YYZ XZZ XYY XXY
 */
