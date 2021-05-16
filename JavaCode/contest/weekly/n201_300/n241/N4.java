package JavaCode.contest.weekly.n201_300.n241;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N4 {
    public static void main(String[] args) {
        //TODO  TimeOut
        System.out.println(new N4().rearrangeSticks(105,28));
    }
    private final static int MOD= (int) (Math.pow(10,9)+7);
    private final static byte yes=1;
    private final static byte no=0;
    public int rearrangeSticks(int n, int k) {
        byte[] book=new byte[n+1];
        Arrays.fill(book,no);
        Map<String,Integer> map=new HashMap<>();
        int[][][] dp=new int[n+1][k+2][n+1];
        for (int[][] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(ints[j], -1);
            }
        }
        book[0]=yes;
        return slove(0,1,n,k,book,dp);
    }

    private int slove(int preMax, int idx, final int n, int k, byte[] book, int[][][] dp) {
        if(idx==n+1){
            if(k==0)return 1;
            else return 0;
        }
        if(k>n-idx+1)return 0;

        String key=preMax+"::"+k+"::"+idx;
        if(dp[preMax][k+1][idx]!=-1)return dp[preMax][k+1][idx];
        long res=0L;
        for (int i=1;i<=Math.min(n-k+1,n);i++){
            if(book[i]==yes)continue;
            book[i]=yes;
            if(i>preMax){
                res+=slove(i,idx+1,n,Math.max(k-1,-1),book,dp);
            }
            else {
                res+=slove(preMax,idx+1,n,k,book,dp);
            }
            res%=MOD;
            book[i]=no;
        }
        return dp[preMax][k+1][idx]=(int) res;
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
