package JavaCode.contest.biweekly.biweekly_n17;

import java.util.*;

/**
 * author:fangjie
 * time:2020/1/11
 */
public class N4 {
    public int distinctEchoSubstrings(String text) {
        if(text.length()<=1)return 0;
        char[] strs=text.toCharArray();
        Set<String> set=new HashSet<>(text.length()/2+15);
        int[][] dp=new int[text.length()][text.length()];
        for (int i=0;i<strs.length;i++)
        {
            for (int j=i+1;j<strs.length;j++)
            {
                if(strs[i]==strs[j])
                {
                    if(i==0)dp[i][j]=1;
                    else dp[i][j]=1+dp[i-1][j-1];
                }
                if(dp[i][j]>=j-i)
                {
                    int start=2*i-j+1;
                    set.add(new String(strs,start,j-start+1));
                }
            }
        }
        return set.size();
    }
}
/*
给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：这些子字符串可以写成某个字符串与其自身的串联。



示例 1：

输入：text = "abcabcabc"
输出：3
解释：3 个子字符串分别为 "abcabc" ， "bcabca" 和 "cabcab" 。
示例 2：

输入：text = "leetcodeleetcode"
输出：2
解释：2 个子字符串为 "ee" 和 "leetcodeleetcode" 。


提示：

1 <= text.length <= 2000
text 只包含小写英文字母。
 */
