package JavaCode.contest.other.fall_2020;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/9/12 2:43 下午
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(new N3().minimumOperations("rrryyyrryyyrr"));
    }

    public int minimumOperations(String leaves) {
        int[][] dp=new int[3][leaves.length()];

        char[] strs=leaves.toCharArray();
        dp[0][0]=help(strs[0], 'r');
        dp[1][0]=dp[2][0]=leaves.length();

        for (int i=1; i<strs.length; i++) {
            dp[0][i]=dp[0][i-1]+help(strs[i],'r');
            dp[1][i]=Math.min(dp[0][i-1],dp[1][i-1])+help(strs[i],'y');
            dp[2][i]=Math.min(dp[1][i-1],dp[2][i-1])+help(strs[i],'r');
        }
        return dp[2][leaves.length()-1];
    }

    private int help(char c1, char c2) {
        return c1==c2 ? 0 : 1;
    }

}
/*
小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。

示例 1：

输入：leaves = "rrryyyrryyyrr"

输出：2

解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"

示例 2：

输入：leaves = "ryr"

输出：0

解释：已符合要求，不需要额外操作

提示：

3 <= leaves.length <= 10^5
leaves 中只包含字符 'r' 和字符 'y'

 */
