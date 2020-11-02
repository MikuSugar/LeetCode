package JavaCode.contest.weekly.n0_200.n157;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/10/6
 */
public class N4 {
    private final static char[] chars={'a', 'e', 'i', 'o', 'u'};
    private final static int MOD=(int) (1e9+7);
    public int countVowelPermutation(int n) {
        long res=0;
        long[][] dp=new long[5][n];
        for (int i=0;i<5;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for (char a:chars)
        {
            res+=slove(a,n-1,dp)%MOD;
        }
        return (int) (res%MOD);
    }

    private long slove(char a, int len, long[][] dp) {
        if(len==0)return 1;
        int idx=getIdx(a);
        if(dp[idx][len]!=-1)return dp[idx][len];
        long res=0;
        if(a=='a')res=slove('e',len-1,dp)%MOD;
        else if(a=='e') res=slove('a',len-1,dp)%MOD+slove('i',len-1,dp)%MOD;
        else if(a=='i')
        {
            for (int i=0;i<5;i++)
            {
                if(i==2)continue;
                res+=slove(chars[i],len-1,dp);
                res%=MOD;
            }
        }
        else if(a=='o') res=slove('i',len-1,dp)%MOD+slove('u',len-1,dp)%MOD;
        else res=slove('a',len-1,dp)%MOD;
        res%=MOD;
        return dp[idx][len]=res;
    }

    private int getIdx(char a) {
        if(a=='a')return 0;
        if(a=='e')return 1;
        if(a=='i')return 2;
        if(a=='o')return 3;
        return 4;
    }
}
/**
 *给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 *
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 * 示例 3：
 *
 * 输入：n = 5
 * 输出：68
 *
 *
 * 提示：
 *
 * 1 <= n <= 2 * 10^4
 */
