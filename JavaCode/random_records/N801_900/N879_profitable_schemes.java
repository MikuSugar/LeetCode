package JavaCode.random_records.N801_900;

/**
 * author:fangjie
 * time:2019/12/16
 */
public class N879_profitable_schemes {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        final int MOD=(int) (1e9+7);
        int[][] dp=new int[G+1][P+1];
        for (int i=0;i<=G;i++)
        {
            dp[i][0]=1;
        }
        for (int k=1;k<=profit.length;k++)
        {
            int p=profit[k-1];
            int g=group[k-1];
            for (int i=G;i>=g;i--)
            {
                for (int j=0;j<=P;j++)
                {
                    dp[i][j]+=dp[i-g][Math.max(j-p,0)];
                    dp[i][j]%=MOD;
                }
            }
        }
        return dp[G][P];
    }
}
/*
帮派里有 G 名成员，他们可能犯下各种各样的罪行。

第 i 种犯罪会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。

让我们把这些犯罪的任何子集称为盈利计划，该计划至少产生 P 的利润。

有多少种方案可以选择？因为答案很大，所以返回它模 10^9 + 7 的值。

 

示例 1：

输入：G = 5, P = 3, group = [2,2], profit = [2,3]
输出：2
解释：
至少产生 3 的利润，该帮派可以犯下罪 0 和罪 1 ，或仅犯下罪 1 。
总的来说，有两种方案。
示例 2:

输入：G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
输出：7
解释：
至少产生 5 的利润，只要他们犯其中一种罪就行，所以该帮派可以犯下任何罪行 。
有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 

提示：

1 <= G <= 100
0 <= P <= 100
1 <= group[i] <= 100
0 <= profit[i] <= 100
1 <= group.length = profit.length <= 100
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/profitable-schemes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
