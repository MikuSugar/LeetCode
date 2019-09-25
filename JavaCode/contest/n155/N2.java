package JavaCode.contest.n155;

/**
 * author:fangjie
 * time:2019/9/24
 */
public class N2 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left=0,right=Integer.MAX_VALUE;
        while (left+1<right)
        {
            long mid=(left+right)/2;
            long cnt=mid/a;
            cnt+=mid/b;
            cnt+=mid/c;
            long temp=(long)a*b/gcd(a,b);
            cnt-=mid/temp;
            cnt-=mid/((long)a*c/gcd(a,c));
            cnt-=mid/((long)c*b/gcd(c,b));
            cnt+=mid/(temp*c/gcd(temp,c));
            if(cnt<n)left=mid;
            else right=mid;
        }
        return (int)right;
    }

    private long gcd(long a,long b)
    {
        return b==0?a:gcd(b,a%b);
    }
}
/**
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。
 *
 * 丑数是可以被 a 或 b 或 c 整除的 正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 * 示例 2：
 *
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 12... 其中第 4 个是 6。
 * 示例 3：
 *
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 * 示例 4：
 *
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 *
 *
 * 提示：
 *
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * 本题结果在 [1, 2 * 10^9] 的范围内
 */
