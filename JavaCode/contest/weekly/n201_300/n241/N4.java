package JavaCode.contest.weekly.n201_300.n241;


public class N4 {
    public static void main(String[] args) {
        //TODO  TimeOut
        System.out.println(new N4().rearrangeSticks(500,28));
    }
    private final static int MOD= (int) (Math.pow(10,9)+7);
    public int rearrangeSticks(int n, int k) {
        long[][] dp=new long[n+1][k+1];
        dp[0][0]=1;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=k;j++){
                dp[i][j]=(dp[i-1][j-1]+(i-1)*dp[i-1][j])%MOD;
            }
        }
        return (int) dp[n][k];
    }
}
/*
有 n 根长度互不相同的木棍，长度为从 1 到 n 的整数。请你将这些木棍排成一排，并满足从左侧 可以看到 恰好 k 根木棍。从左侧 可以看到 木棍的前提是这个木棍的 左侧 不存在比它 更长的 木棍。

例如，如果木棍排列为 [1,3,2,5,4] ，那么从左侧可以看到的就是长度分别为 1、3 、5 的木棍。
给你 n 和 k ，返回符合题目要求的排列 数目 。由于答案可能很大，请返回对 109 + 7 取余 的结果。



示例 1：

输入：n = 3, k = 2
输出：3
解释：[1,3,2], [2,3,1] 和 [2,1,3] 是仅有的能满足恰好 2 根木棍可以看到的排列。
可以看到的木棍已经用粗体+斜体标识。
示例 2：

输入：n = 5, k = 5
输出：1
解释：[1,2,3,4,5] 是唯一一种能满足全部 5 根木棍可以看到的排列。
可以看到的木棍已经用粗体+斜体标识。
示例 3：

输入：n = 20, k = 11
输出：647427950
解释：总共有 647427950 (mod 109 + 7) 种能满足恰好有 11 根木棍可以看到的排列。


提示：

1 <= n <= 1000
1 <= k <= n
 */
