package JavaCode.random_records.N301_400;


public class N357_count_numbers_with_unique_digits
{
    private static int[] dp;
    static
    {
        dp=new int[11];
        dp[0]=1;
        dp[1]=9;
        for (int i=2;i<=10;i++)
        {
            dp[i]=dp[i-1]*(11-i);
        }
        for (int i=1;i<=10;i++)
        {
            dp[i]+=dp[i-1];
        }
    }
    public int countNumbersWithUniqueDigits(int n) {
        return dp[n>10?10:n];
    }
}
/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
