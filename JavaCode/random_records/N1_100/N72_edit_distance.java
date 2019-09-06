package JavaCode.random_records.N1_100;

public class N72_edit_distance {
    public int minDistance(String word1, String word2) {
        if(word1.length()*word2.length()==0)return word1.length()+word2.length();
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int[][] dp=new int[s1.length+1][s2.length+1];
        for (int i=0;i<=s1.length;i++)
        {
            dp[i][0]=i;
        }
        for (int i=0;i<=s2.length;i++)
        {
            dp[0][i]=i;
        }
        for (int i=1;i<=s1.length;i++)
        {
            for (int j=1;j<=s2.length;j++)
            {
                int temp=dp[i-1][j-1];
                if(s1[i-1]!=s2[j-1])temp++;
                dp[i][j]=Math.min(temp,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
            }
        }
        return dp[s1.length][s2.length];
    }
}
/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
