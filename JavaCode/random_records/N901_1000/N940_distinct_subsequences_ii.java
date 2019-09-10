package JavaCode.random_records.N901_1000;

import java.util.Arrays;

public class N940_distinct_subsequences_ii {
    private final static int MOD=(int) (1e9+7);
    public int distinctSubseqII(String S) {
        int[] dp=new int[S.length()+1];
        dp[0]=1;
        int[] book=new int[26];
        Arrays.fill(book,-1);
        char[] s=S.toCharArray();
        for (int i=0;i<s.length;i++)
        {
            dp[i+1]=2*dp[i]%MOD;
            if(book[s[i]-'a']!=-1)
            {
                dp[i+1]-=dp[book[s[i]-'a']];
            }
            dp[i+1]%=MOD;
            book[s[i]-'a']=i;
        }
        dp[S.length()]--;
        return dp[S.length()]<0?dp[S.length()]+MOD:dp[S.length()];
    }
}
/**
 * 给定一个字符串 S，计算 S 的不同非空子序列的个数。
 *
 * 因为结果可能很大，所以返回答案模 10^9 + 7.
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * 示例 2：
 *
 * 输入："aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * 示例 3：
 *
 * 输入："aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 *  
 *
 *  
 *
 * 提示：
 *
 * S 只包含小写字母。
 * 1 <= S.length <= 2000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
