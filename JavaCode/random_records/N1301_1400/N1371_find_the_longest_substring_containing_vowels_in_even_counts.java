package JavaCode.random_records.N1301_1400;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2020/3/18
 */
public class N1371_find_the_longest_substring_containing_vowels_in_even_counts {
    public int findTheLongestSubstring(String s) {
        int[] dp=new int[32];
        Arrays.fill(dp,s.length());
        dp[0]=-1;
        int res=0;
        for (int i=0,cur=0;i<s.length();i++)
        {
            int idx=getIdx(s.charAt(i));
            if(idx>=0)
            {
                cur^=(1<<idx);
            }
            dp[cur]=Math.min(dp[cur],i);
            res=Math.max(res,i-dp[cur]);
        }
        return res;
    }
    private int getIdx(char c)
    {
        for (int i=0;i<VOWELS.length;i++)
        {
            if(c==VOWELS[i])return i;
        }
        return -1;
    }
    private final static char[] VOWELS={'a','e','i','o','u'};
}
/*
给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。



示例 1：

输入：s = "eleetminicoworoep"
输出：13
解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
示例 2：

输入：s = "leetcodeisgreat"
输出：5
解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
示例 3：

输入：s = "bcbcbc"
输出：6
解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。


提示：

1 <= s.length <= 5 x 10^5
s 只包含小写英文字母。
 */
