package JavaCode.random_records.N501_600;

/**
 * author:fangjie
 * time:2019/11/27
 */
public class N583_delete_operation_for_two_strings {
    public int minDistance(String word1, String word2) {
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int[][] dp=new int[s1.length+1][s2.length+1];
        for (int i=1;i<dp.length;i++)
        {
            for (int j=1;j<dp[0].length;j++)
            {
                if(s1[i-1]==s2[j-1]) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return s1.length+s2.length-2*dp[s1.length][s2.length];
    }
}
/*
给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。

示例 1:

输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
说明:

给定单词的长度不超过500。
给定单词中的字符只含有小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
