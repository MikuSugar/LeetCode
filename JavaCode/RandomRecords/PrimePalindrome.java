package JavaCode.RandomRecords;

public class PrimePalindrome
{
    public int primePalindrome(int N)
    {
        if (N <= 11) {
            if (N <= 2)
                return 2;
            else if (N == 3)
                return 3;
            else if (N <= 5)
                return 5;
            else if (N <= 7)
                return 7;
            else
                return 11;
        }
        N=N%2==0?N+1:N;
        for (int i=N;;i+=2)
        {
            if(isPa(i)&&isPr(i))
            {
                return i;
            }
        }
    }

    boolean isPa(int n)
    {
        char[] c=new Integer(n).toString().toCharArray();
        int len=c.length;
        int mid=len>>1;
        for(int i=0,j=len-1;i<mid;i++,j--)
        {
            if(c[i]!=c[j])return false;
        }
        return true;
    }

    boolean isPr(int n)
    {
        if(n<=1) return false;

        if(n==2||n==3) return true;

        //不在6的倍数两侧的一定不是素数
        if(n%6!=1 && n%6!=5) {
            return false;
        }

        int temp=(int) Math.sqrt(n);
        for (int i=2;i<=temp;i++)
        {
            if(n%i==0)return false;
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/contest/weekly-contest-92/problems/prime-palindrome/
 * 866. 回文素数
 * 题目难度 Medium
 * 求出大于或等于 N 的最小回文素数。
 *
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 *
 * 例如，2，3，5，7，11 以及 13 是素数。
 *
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 *
 * 例如，12321 是回文数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：6
 * 输出：7
 * 示例 2：
 *
 * 输入：8
 * 输出：11
 * 示例 3：
 *
 * 输入：13
 * 输出：101
 *
 *
 * 提示：
 *
 * 1 <= N <= 10^8
 * 答案肯定存在，且小于 2 * 10^8。
 */
