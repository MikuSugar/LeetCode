package JavaCode.random_records.N401_500;

public class N479_largest_palindrome_product {
    private static int MOD=1337;
    public int largestPalindrome(int n) {
        if(n==1)return 9;
        int max=(int)Math.pow(10,n)-1;
        for (int i=max-1;i>max/10;i--)
        {
            long num=Long.valueOf(i+new StringBuilder().append(i).reverse().toString());
            for (long j=max;j*j>=num;j--)
            {
                if(num%j==0)return (int)(num%MOD);
            }
        }
        return -1;

    }
}
/**
 * 你需要找到由两个 n 位数的乘积组成的最大回文数。
 *
 * 由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。
 *
 * 示例:
 *
 * 输入: 2
 *
 * 输出: 987
 *
 * 解释: 99 x 91 = 9009, 9009 % 1337 = 987
 *
 * 说明:
 *
 * n 的取值范围为 [1,8]。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-palindrome-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
