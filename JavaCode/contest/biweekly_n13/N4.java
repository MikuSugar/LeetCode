package JavaCode.contest.biweekly_n13;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/11/16
 */
public class N4 {
    public int numberOfWays(int num_people) {
        int[] dp=new int[num_people+1];
        Arrays.fill(dp,-1);
        return slove(num_people,dp);
    }

    private int slove(int num_people, int[] dp) {
        if(num_people<=2)return 1;
        if(dp[num_people]!=-1)return dp[num_people];
        int res=0;
        int max=num_people-2;
        for (int i=0;i<=max;i+=2)
        {
            long s1=slove(i,dp);
            long s2=slove(max-i,dp);
            res+=(s1*s2)%MOD;
            res%=MOD;
        }
        return dp[num_people]=res;
    }
    private final static int MOD=(int) (1e9+7);
}
/*
偶数 个人站成一个圆，总人数为 num_people 。每个人与除自己外的一个人握手，所以总共会有 num_people / 2 次握手。

将握手的人之间连线，请你返回连线不会相交的握手方案数。

由于结果可能会很大，请你返回答案 模 10^9+7 后的结果。



示例 1：

输入：num_people = 2
输出：1
示例 2：



输入：num_people = 4
输出：2
解释：总共有两种方案，第一种方案是 [(1,2),(3,4)] ，第二种方案是 [(2,3),(4,1)] 。
示例 3：



输入：num_people = 6
输出：5
示例 4：

输入：num_people = 8
输出：14


提示：

2 <= num_people <= 1000
num_people % 2 == 0
 */
