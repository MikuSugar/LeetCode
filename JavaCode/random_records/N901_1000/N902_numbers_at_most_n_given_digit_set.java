package JavaCode.random_records.N901_1000;

/**
 * author:fangjie
 * time:2019/10/16
 */
public class N902_numbers_at_most_n_given_digit_set {
    public int atMostNGivenDigitSet(String[] D, int N) {
        String n=String.valueOf(N);
        int[] dp=new int[n.length()+1];
        dp[n.length()]=1;
        for (int i=n.length()-1;i>=0;i--)
        {
            int si=n.charAt(i)-'0';
            for (String d:D)
            {
                int dd=Integer.parseInt(d);
                if(dd<si) dp[i]+=Math.pow(D.length,n.length()-i-1);
                else if(dd==si) dp[i]+=dp[i+1];
            }
        }
        for (int i=1;i<n.length();i++)
        {
            dp[0]+=Math.pow(D.length,i);
        }
        return dp[0];
    }
}
/**
 * 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）
 *
 * 现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。
 *
 * 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：D = ["1","3","5","7"], N = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * 示例 2：
 *
 * 输入：D = ["1","4","9"], N = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 *  
 *
 * 提示：
 *
 * D 是按排序顺序的数字 '1'-'9' 的子集。
 * 1 <= N <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/numbers-at-most-n-given-digit-set
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
