package JavaCode.random_records.N301_400;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2020/4/13
 */
public class N375_guess_number_higher_or_lower_ii {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+5][n+5];
        for (int[] a:dp)Arrays.fill(dp,-1);
        return slove(1,n,dp);
    }

    private int slove(int left, int right, int[][] dp) {
        if(left>=right)return 0;
        if(dp[left][right]!=-1)return dp[left][right];
        int res=Integer.MAX_VALUE;
        for (int i=left;i<=right;i++)
        {
            res=Math.min(res,i+Math.max(slove(left,i-1,dp),slove(i+1,right,dp)));
        }
        return dp[left][right]=res;
    }
}
/*
我们正在玩一个猜数游戏，游戏规则如下：

我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。

每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。

然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。

示例:

n = 10, 我选择了8.

第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。

游戏结束。8 就是我选的数字。

你最终要支付 5 + 7 + 9 = 21 块钱。
给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
