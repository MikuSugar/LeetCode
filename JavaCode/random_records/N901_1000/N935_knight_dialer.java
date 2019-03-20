package JavaCode.random_records.N901_1000;

import java.util.Arrays;

public class N935_knight_dialer {
    public int knightDialer(int N) {
        if(N==1) return 10;

        int mod=(int)Math.pow(10,9)+7;
        long[] dp=new long[10];
        Arrays.fill(dp,1);
        while (N-->1)
        {
            long[] temp=Arrays.copyOf(dp,10);
            dp[0]=(temp[4]+temp[6])%mod;
            dp[1]=(temp[8]+temp[6])%mod;
            dp[2]=(temp[7]+temp[9])%mod;
            dp[3]=(temp[4]+temp[8])%mod;
            dp[4]=(temp[3]+temp[9]+temp[0])%mod;
            dp[6]=(temp[1]+temp[7]+temp[0])%mod;
            dp[7]=(temp[2]+temp[6])%mod;
            dp[8]=(temp[1]+temp[3])%mod;
            dp[9]=(temp[4]+temp[2])%mod;
        }
        long res=0;
        for (long i:dp)
        {
            res+=i;
            res%=mod;
        }
        return (int)res-1;
    }
}
/**
 * https://leetcode-cn.com/problems/knight-dialer/
 * 国际象棋中的骑士可以按下图所示进行移动：
 *
 *  .
 *
 *
 * 这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。
 *
 * 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。
 *
 * 你能用这种方式拨出多少个不同的号码？
 *
 * 因为答案可能很大，所以输出答案模 10^9 + 7。
 *
 *
 *
 * 示例 1：
 *
 * 输入：1
 * 输出：10
 * 示例 2：
 *
 * 输入：2
 * 输出：20
 * 示例 3：
 *
 * 输入：3
 * 输出：46
 */
